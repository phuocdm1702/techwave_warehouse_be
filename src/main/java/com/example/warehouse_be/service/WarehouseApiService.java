package com.example.warehouse_be.service;

import com.example.warehouse_be.entity.Area;
import com.example.warehouse_be.entity.Board;
import com.example.warehouse_be.entity.ProductEntity.Product;
import com.example.warehouse_be.network.UDPClient;
import com.example.warehouse_be.protocol.PacketBuilder;
import com.example.warehouse_be.service.ProductService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WarehouseApiService {

    private final ProductService productService;

    // --- Data Storage ---
    private final Map<String, Product> rfidToProductMap = new HashMap<>();
    private Product lastScannedProduct = null;

    // --- State Management ---
    private String rfidWaitingForExportConfirmation = null;
    private Thread flashingThread;
    private Area flashingArea = null;
    private volatile boolean stopFlashing = false;

    @Autowired
    public WarehouseApiService(ProductService productService) {
        this.productService = productService;
        System.out.println("Warehouse API Service is ready.");
    }

    public String handleInput(String inputLine) {
        String command = inputLine.trim();
        if (command.isEmpty()) {
            return "[ERROR] Input cannot be empty.";
        }

        if (this.rfidWaitingForExportConfirmation != null) {
            return "[ACTION REQUIRED] An export is pending for RFID '" + this.rfidWaitingForExportConfirmation + "'. Please find the item and call the '/confirm' endpoint.";
        }

        // Heuristic to differentiate between product code and RFID
        if (command.toUpperCase().startsWith("SP")) { // Assuming product codes start with SP
            return handleProductScan(command);
        } else {
            return handleRfidScan(command);
        }
    }

    public String handleExportConfirmation() {
        if (this.rfidWaitingForExportConfirmation == null) {
            return "[INFO] No export operation is waiting for confirmation.";
        }

        String rfidTag = this.rfidWaitingForExportConfirmation;
        Product product = rfidToProductMap.get(rfidTag);

        if (product == null) {
            this.rfidWaitingForExportConfirmation = null;
            return "[ERROR] Product not found for RFID: " + rfidTag;
        }

        String message = "CONFIRMED: Completing export for product '" + product.getProductName() + "' with RFID '" + rfidTag + "'.";

        if (flashingArea != null) {
            String areaName = flashingArea.getAreaName();
            stopFlashingLed();
            controlLed(flashingArea, false);
            flashingArea = null; // CHỈ set null sau khi đã sử dụng
            message += "\n-> LED for area '" + areaName + "' turned OFF.";
        } else {
            stopFlashingLed(); // Vẫn dừng flashing nếu có
        }

        rfidToProductMap.remove(rfidTag);
        this.rfidWaitingForExportConfirmation = null;
        message += "\n-> RFID tag '" + rfidTag + "' is now free. System is ready for the next operation.";
        return message;
    }
    private String handleProductScan(String productCode) {
        Product product = productService.findByProductCode(productCode);
        if (product == null) {
            return "[ERROR] Product with code '" + productCode + "' not found.";
        }

        this.lastScannedProduct = product;
        return "OK: Product '" + product.getProductName() + "' scanned. Now scan the RFID tag to associate.";
    }

    private String handleRfidScan(String rfidTag) {
        if (this.lastScannedProduct != null) {
            if (rfidToProductMap.containsKey(rfidTag)) {
                this.lastScannedProduct = null; // Clear state
                Product existingProduct = rfidToProductMap.get(rfidTag);
                return "[WARN] This RFID tag is already associated with product '" + existingProduct.getProductName() + "'. Please handle the export first.";
            }

            Product currentProduct = this.lastScannedProduct;
            rfidToProductMap.put(rfidTag, currentProduct);

            Area area = currentProduct.getArea();
            if (area != null) {
                controlLed(area, true);
            }

            this.lastScannedProduct = null; // Reset
            return "IMPORT: Associated RFID tag '" + rfidTag + "' with product '" + currentProduct.getProductName() + "'. LED for area '" + area.getAreaName() + "' is ON.";

        } else {
            if (rfidToProductMap.containsKey(rfidTag)) {
                Product productToExp = rfidToProductMap.get(rfidTag);
                Area area = productToExp.getArea();

                if (area != null) {
                    startFlashingLed(area);
                }

                this.rfidWaitingForExportConfirmation = rfidTag;
                return "EXPORT: Found product '" + productToExp.getProductName() + "'. LED for area '" + area.getAreaName() + "' is now flashing. Please find the item and call the '/confirm' endpoint.";
            } else {
                return "INFO: Scanned free RFID tag '" + rfidTag + "'. Not associated with any product.";
            }
        }
    }

    private void controlLed(Area area, boolean turnOn) {
        if (area == null || area.getBoard() == null || area.getRelayNumber() == null) {
            System.err.println("[WARN] Cannot control LED: Area, Board, or Relay Number is null.");
            return;
        }

        Board board = area.getBoard();
        int relayNumber = area.getRelayNumber();

        try {
            if (turnOn) {
                byte[] packet = PacketBuilder.sendControlCommand(board, 1, relayNumber);
                UDPClient.send(board, packet);
                System.out.println("UDP command to turn ON LED for area '" + area.getAreaName() + "' sent.");
            } else {
                System.out.println("[SIMULATED] Turning OFF LED for area '" + area.getAreaName() + "'. Implement the actual UDP 'OFF' command if available.");
            }
        } catch (Exception e) {
            System.err.println("[ERROR] Failed to send UDP command for area '" + area.getAreaName() + "': " + e.getMessage());
        }
    }

    private void startFlashingLed(Area area) {
        if (area == null || area.getBoard() == null || area.getRelayNumber() == null) {
            System.err.println("[WARN] Cannot start flashing: Area, Board, or Relay Number is null.");
            return;
        }

        stopFlashing = false;
        flashingArea = area;
        flashingThread = new Thread(() -> {
            Board board = area.getBoard();
            int relayNumber = area.getRelayNumber();
            while (!stopFlashing) {
                try {
                    byte[] packet = PacketBuilder.sendControlCommand(board, 1, relayNumber);
                    UDPClient.send(board, packet);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                } catch (Exception e) {
                    // Log silently in a real app
                }
            }
        });
        flashingThread.start();
    }

    private void stopFlashingLed() {
        stopFlashing = true;
        if (flashingThread != null) {
            flashingThread.interrupt();
            try {
                flashingThread.join(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            flashingThread = null;
        }
    }

    public Product findProductByRfid(String rfidTag) {
        Product product = rfidToProductMap.get(rfidTag);
        if (product != null) {
            Area area = product.getArea();
            if (area != null) {
                startFlashingLed(area);
            }
            this.rfidWaitingForExportConfirmation = rfidTag;
        }
        return product;
    }
}

package com.example.warehouse_be.controller;

import com.example.warehouse_be.entity.ProductEntity.Product;
import com.example.warehouse_be.model.response.ProductDetailResponse;
import com.example.warehouse_be.service.WarehouseApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/warehouse")
public class WarehouseApiController {

    private final WarehouseApiService warehouseApiService;

    @Autowired
    public WarehouseApiController(WarehouseApiService warehouseApiService) {
        this.warehouseApiService = warehouseApiService;
    }

    /**
     * Handles a scan event from a QR code or RFID reader.
     * @param payload A JSON object containing the scanned data, e.g., {"scanData": "PRD1"}
     * @return A response entity with the result of the operation.
     */
    @PostMapping("/scan")
    public ResponseEntity<String> handleScan(@RequestBody Map<String, String> payload) {
        String scanData = payload.get("scanData");
        if (scanData == null || scanData.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("scanData field is required.");
        }
        String result = warehouseApiService.handleInput(scanData);
        return ResponseEntity.ok(result);
    }

    /**
     * Confirms the completion of an export operation.
     * @return A response entity with the result of the confirmation.
     */
    @PostMapping("/confirm")
    public ResponseEntity<String> confirmExport() {
        String result = warehouseApiService.handleExportConfirmation();
        return ResponseEntity.ok(result);
    }

    /**
     * Finds a product by its assigned RFID tag.
     * @param rfidTag The RFID tag to search for.
     * @return The product details if found, otherwise a 404 Not Found response.
     */
    @GetMapping("/rfid/{rfidTag}")
    public ResponseEntity<?> findProductByRfid(@PathVariable String rfidTag) {
        Product response = warehouseApiService.findProductByRfid(rfidTag);
        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

package com.example.warehouse_be.model.response;

import com.example.warehouse_be.entity.ProductEntity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDetailResponse {
    // Product information
    private Integer productId;
    private String productCode;
    private String productName;
    private String serialNumber;
    private Integer currentStock;
    private Integer lowStockThreshold;
    private Integer maxStockThreshold;
    private Double unitPrice;
    private String createdDate;
    private String updatedDate;

    // Color information
    private String colorName;
    private String hexValue;

    // Material information
    private String materialName;
    private String materialDescription;

    // Product Type information
    private String productTypeName;

    // Size information
    private String sizeName;
    private String sizeDimensions;

    // Weight information
    private Double weightValue;
    private String weightUnit;

    // Area information
    private String areaCode;
    private String areaName;
    private String location;

    // Board information
    private String ipAddress;
    private Integer port;
    private Integer boardSerialNumber;

    public ProductDetailResponse(Product product) {
        this.productId = product.getProductId();
        this.productCode = product.getProductCode();
        this.productName = product.getProductName();
        this.serialNumber = product.getSerialNumber();
        this.currentStock = product.getCurrentStock();
        this.lowStockThreshold = product.getLowStockThreshold();
        this.maxStockThreshold = product.getMaxStockThreshold();
        this.unitPrice = product.getUnitPrice();
        this.createdDate = product.getCreatedDate() != null ? product.getCreatedDate().toString() : null;
        this.updatedDate = product.getUpdatedDate() != null ? product.getUpdatedDate().toString() : null;

        // Color
        if (product.getColor() != null) {
            this.colorName = product.getColor().getColorName();
            this.hexValue = product.getColor().getHexValue();
        }

        // Material
        if (product.getMaterial() != null) {
            this.materialName = product.getMaterial().getMaterialName();
            this.materialDescription = product.getMaterial().getDescription();
        }

        // Product Type
        if (product.getProductType() != null) {
            this.productTypeName = product.getProductType().getProductTypeName();
        }

        // Size
        if (product.getSize() != null) {
            this.sizeName = product.getSize().getSizeName();
            this.sizeDimensions = String.format("%s x %s x %s %s",
                    product.getSize().getLength(),
                    product.getSize().getWidth(),
                    product.getSize().getHeight(),
                    product.getSize().getUnit());
        }

        // Weight
        if (product.getWeight() != null) {
            this.weightValue = product.getWeight().getValue();
            this.weightUnit = product.getWeight().getUnit();
        }

        // Area
        if (product.getArea() != null) {
            this.areaCode = product.getArea().getAreaCode();
            this.areaName = product.getArea().getAreaName();
            this.location = product.getArea().getLocation();
        }

        // Board
        if (product.getArea() != null && product.getArea().getBoard() != null) {
            this.ipAddress = product.getArea().getBoard().getIp();
            this.port = product.getArea().getBoard().getPort();
            this.boardSerialNumber = product.getArea().getBoard().getSerialNumber();
        }
    }
}


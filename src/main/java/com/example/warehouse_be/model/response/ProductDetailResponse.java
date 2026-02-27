package com.example.warehouse_be.model.response;

import com.example.warehouse_be.entity.ProductEntity.Product;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

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
    private BigDecimal unitPrice;
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
    private BigDecimal weightValue;
    private String weightUnit;

    // Area information
    private String areaCode;
    private String areaName;
    private String location;

    // Board information
    private String ipAddress;
    private Integer port;
    private Integer boardSerialNumber;

    // RFID information
    private java.util.List<String> rfidTags;

    public ProductDetailResponse(Product product) {
        this.productId = product.getId();
        this.productCode = product.getProductCode();
        this.productName = product.getProductName();
        this.createdDate = product.getCreatedAt() != null ? product.getCreatedAt().toString() : null;

        if (product.getType() != null) {
            this.productTypeName = product.getType().getTypeName();
        }
    }
}


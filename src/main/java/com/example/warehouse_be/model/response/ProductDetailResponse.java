package com.example.warehouse_be.model.response;

import com.example.warehouse_be.entity.ProductEntity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDetailResponse {
    // Product information
    private String productCode;
    private String productName;
    private String serialNumber;
    private Integer currentStock;
    private Integer lowStockThreshold;
    private Integer maxStockThreshold;
    private Double unitPrice;

    // Area information
    private String areaCode;
    private String areaName;
    private String location;

    // Board information
    private String ipAddress;
    private Integer port;
    private Integer boardSerialNumber;

    public ProductDetailResponse(Product product) {
        this.productCode = product.getProductCode();
        this.productName = product.getProductName();
        this.serialNumber = product.getSerialNumber();
        this.currentStock = product.getCurrentStock();
        this.lowStockThreshold = product.getLowStockThreshold();
        this.maxStockThreshold = product.getMaxStockThreshold();
        this.unitPrice = product.getUnitPrice();

        this.areaCode = product.getArea().getAreaCode();
        this.areaName = product.getArea().getAreaName();
        this.location = product.getArea().getLocation();

        this.ipAddress = product.getArea().getBoard().getIp();
        this.port = product.getArea().getBoard().getPort();
        this.boardSerialNumber = product.getArea().getBoard().getSerialNumber();
    }
}

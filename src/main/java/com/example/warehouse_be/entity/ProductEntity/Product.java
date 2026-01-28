package com.example.warehouse_be.entity.ProductEntity;

import com.example.warehouse_be.entity.Area;
import lombok.*;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Product {
    private Integer productId;
    private String productCode;
    private String productName;
    private String serialNumber;
    private Integer currentStock;
    private Integer lowStockThreshold;
    private Integer maxStockThreshold;
    private Double unitPrice;
    private Date createdDate;
    private Date updatedDate;

    private Color color;
    private Material material;
    private ProductType productType;
    private Size size;
    private Weight weight;
    private Area area;
}

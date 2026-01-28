package com.example.warehouse_be.entity.ProductEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductType {
    private Integer productTypeId;
    private Integer productTypeCode;
    private String productTypeName;
}

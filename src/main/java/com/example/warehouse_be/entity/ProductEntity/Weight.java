package com.example.warehouse_be.entity.ProductEntity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Weight {
    private Integer weightId;
    private String weightCode;
    private Double value; // Giá trị khối lượng
    private String unit;  // Đơn vị (g, kg, lb,...)
}

package com.example.warehouse_be.entity.ProductEntity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Color {
    private Integer colorId;
    private String colorCode;
    private String colorName;
    private String hexValue;
}

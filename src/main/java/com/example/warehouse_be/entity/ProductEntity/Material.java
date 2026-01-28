package com.example.warehouse_be.entity.ProductEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Material {
    private Integer materialId;
    private String materialCode;
    private String materialName;
    private String description; // Mô tả thêm về chất liệu
}

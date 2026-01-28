package com.example.warehouse_be.entity.ProductEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Size {
    private Integer sizeId;
    private String sizeCode;
    private String sizeName;
    private Double length; // Chiều dài
    private Double width;  // Chiều rộng
    private Double height; // Chiều cao
    private String unit;   // Đơn vị (cm, m, inch,...)
}

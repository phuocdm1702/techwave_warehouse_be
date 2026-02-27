package com.example.warehouse_be.entity.ProductEntity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "color")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "color_id")
    private Integer id;

    @Column(name = "color_code")
    private String colorCode;

    @Column(name = "color_name")
    private String colorName;

    @Column(name = "color_name_en")
    private String colorNameEn;

    @Column(name = "hex_value")
    private String hexValue;

}
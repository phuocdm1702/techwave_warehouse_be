package com.example.warehouse_be.entity.ProductEntity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "material")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_id")
    private Integer id;

    @Column(name = "material_code")
    private String materialCode;

    @Column(name = "material_name")
    private String materialName;

    @Column(name = "material_name_en")
    private String materialNameEn;

    @Column(name = "description")
    private String description;

}
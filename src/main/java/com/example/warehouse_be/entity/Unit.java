package com.example.warehouse_be.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "unit")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unit_id")
    private Integer id;

    @Column(name = "unit_code")
    private String unitCode;

    @Column(name = "unit_name")
    private String unitName;

    @Column(name = "unit_type", nullable = false)
    private String unitType;

}
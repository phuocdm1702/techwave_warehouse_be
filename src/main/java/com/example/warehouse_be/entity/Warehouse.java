package com.example.warehouse_be.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "warehouse")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_id")
    private Integer id;

    @Column(name = "warehouse_code")
    private String warehouseCode;

    @Column(name = "warehouse_name")
    private String warehouseName;

    @ColumnDefault("'branch'")
    @Column(name = "warehouse_type")
    private String warehouseType;

    @Column(name = "location")
    private String location;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "area_id", referencedColumnName = "area_id")
    private Area area;

    @Column(name = "manager")
    private String manager;

    @Column(name = "phone")
    private String phone;

    @ColumnDefault("1")
    @Column(name = "is_active")
    private Boolean isActive;

}
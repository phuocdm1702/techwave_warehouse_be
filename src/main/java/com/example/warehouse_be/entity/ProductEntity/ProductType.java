package com.example.warehouse_be.entity.ProductEntity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "product_type")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Integer id;

    @Column(name = "type_code")
    private String typeCode;

    @Column(name = "type_name")
    private String typeName;

    @Column(name = "type_group")
    private String typeGroup;

    @Column(name = "description")
    private String description;

    @ColumnDefault("1")
    @Column(name = "is_active")
    private Boolean isActive;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @OneToMany(mappedBy = "type")
    private Set<Product> products = new LinkedHashSet<>();

}
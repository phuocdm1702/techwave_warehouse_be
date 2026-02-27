package com.example.warehouse_be.entity.CustomerEntity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "customer_type")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_type_id")
    private Integer id;

    @Column(name = "type_code")
    private String typeCode;

    @Column(name = "type_name")
    private String typeName;

    @ColumnDefault("0.00")
    @Column(name = "discount_percent")
    private BigDecimal discountPercent;

    @Column(name = "description")
    private String description;

}
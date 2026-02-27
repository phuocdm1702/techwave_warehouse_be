package com.example.warehouse_be.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "payment_method")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_method_id")
    private Integer id;

    @Column(name = "method_code")
    private String methodCode;

    @Column(name = "method_name")
    private String methodName;

    @Column(name = "description")
    private String description;

    @Column(name = "icon")
    private String icon;

    @ColumnDefault("0.00")
    @Column(name = "transaction_fee")
    private BigDecimal transactionFee;

    @ColumnDefault("'fixed'")
    @Column(name = "fee_type")
    private String feeType;

    @ColumnDefault("1")
    @Column(name = "is_active")
    private Boolean isActive;

    @ColumnDefault("0")
    @Column(name = "sort_order")
    private Integer sortOrder;

}
package com.example.warehouse_be.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "bank")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_id")
    private Integer id;

    @Column(name = "bank_code")
    private String bankCode;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "logo")
    private String logo;

    @ColumnDefault("1")
    @Column(name = "is_active")
    private Boolean isActive;

}
package com.example.warehouse_be.entity.CustomerEntity;

import com.example.warehouse_be.entity.EmployeeEntity.Employee;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;

    @Column(name = "customer_code")
    private String customerCode;

    @Column(name = "customer_name")
    private String customerName;

    @ColumnDefault("'individual'")
    @Column(name = "customer_type")
    private String customerType;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "tax_code")
    private String taxCode;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "ward")
    private String ward;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "anniversary_date")
    private LocalDate anniversaryDate;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "customer_type_id", referencedColumnName = "customer_type_id")
    private CustomerType customerType1;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "sales_employee_id", referencedColumnName = "employee_id")
    private Employee salesEmployee;

    @ColumnDefault("0.00")
    @Column(name = "credit_limit")
    private BigDecimal creditLimit;

    @ColumnDefault("0.00")
    @Column(name = "current_balance")
    private BigDecimal currentBalance;

    @ColumnDefault("0.00")
    @Column(name = "total_purchase")
    private BigDecimal totalPurchase;

    @ColumnDefault("'active'")
    @Column(name = "status")
    private String status;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at")
    private Instant updatedAt;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "created_by", referencedColumnName = "employee_id")
    private Employee createdBy;

}
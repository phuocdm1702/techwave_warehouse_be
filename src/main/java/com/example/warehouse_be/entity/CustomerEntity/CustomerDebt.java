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
@Table(name = "customer_debt")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CustomerDebt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "debt_id")
    private Integer id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    @Column(name = "transaction_date")
    private LocalDate transactionDate;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "reference_id")
    private Integer referenceId;

    @Column(name = "beginning_balance")
    private BigDecimal beginningBalance;

    @Column(name = "transaction_amount")
    private BigDecimal transactionAmount;

    @Column(name = "ending_balance")
    private BigDecimal endingBalance;

    @Column(name = "notes")
    private String notes;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "created_by", referencedColumnName = "employee_id")
    private Employee createdBy;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

}
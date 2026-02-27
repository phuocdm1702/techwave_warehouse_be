package com.example.warehouse_be.entity.InvoiceEntity;

import com.example.warehouse_be.entity.CompanyBankAccount;
import com.example.warehouse_be.entity.EmployeeEntity.Employee;
import com.example.warehouse_be.entity.PaymentMethod;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "invoice_payment")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class InvoicePayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Integer id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "invoice_id", referencedColumnName = "invoice_id")
    private Invoice invoice;

    @Column(name = "payment_date")
    private Instant paymentDate;

    @Column(name = "amount")
    private BigDecimal amount;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "payment_method_id", referencedColumnName = "payment_method_id")
    private PaymentMethod paymentMethod;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "company_bank_id", referencedColumnName = "company_bank_id")
    private CompanyBankAccount companyBank;

    @Column(name = "transaction_code")
    private String transactionCode;

    @Column(name = "reference_number")
    private String referenceNumber;

    @ColumnDefault("'pending'")
    @Column(name = "status")
    private String status;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "created_by", referencedColumnName = "employee_id")
    private Employee createdBy;

    @Column(name = "notes")
    private String notes;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

}
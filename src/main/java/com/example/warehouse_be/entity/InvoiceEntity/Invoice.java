package com.example.warehouse_be.entity.InvoiceEntity;

import com.example.warehouse_be.entity.CustomerEntity.Customer;
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
@Table(name = "invoice")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private Integer id;

    @Column(name = "invoice_no")
    private String invoiceNo;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_phone")
    private String customerPhone;

    @Column(name = "customer_address")
    private String customerAddress;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "sales_employee_id", referencedColumnName = "employee_id")
    private Employee salesEmployee;

    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "employee_id")
    private Employee createdBy;

    @Column(name = "invoice_date")
    private Instant invoiceDate;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "status_id", referencedColumnName = "status_id")
    private InvoiceStatus status;

    @ColumnDefault("0.00")
    @Column(name = "subtotal")
    private BigDecimal subtotal;

    @ColumnDefault("0.00")
    @Column(name = "discount_amount")
    private BigDecimal discountAmount;

    @ColumnDefault("0.00")
    @Column(name = "discount_percent")
    private BigDecimal discountPercent;

    @ColumnDefault("0.00")
    @Column(name = "tax_amount")
    private BigDecimal taxAmount;

    @ColumnDefault("0.00")
    @Column(name = "shipping_fee")
    private BigDecimal shippingFee;

    @ColumnDefault("0.00")
    @Column(name = "total_amount")
    private BigDecimal totalAmount;


    @Column(name = "customer_note")
    private String customerNote;


    @Column(name = "staff_note")
    private String staffNote;


    @Column(name = "cancel_reason")
    private String cancelReason;

    @Column(name = "shipping_address")
    private String shippingAddress;

    @Column(name = "shipping_receiver", length = 100)
    private String shippingReceiver;

    @Column(name = "shipping_phone", length = 20)
    private String shippingPhone;

    @Column(name = "shipping_date")
    private Instant shippingDate;

    @ColumnDefault("'pending'")
    @Column(name = "delivery_status")
    private String deliveryStatus;

    @ColumnDefault("0.00")
    @Column(name = "paid_amount", precision = 15, scale = 2)
    private BigDecimal paidAmount;

    @ColumnDefault("0.00")
    @Column(name = "remaining_amount", precision = 15, scale = 2)
    private BigDecimal remainingAmount;

    @ColumnDefault("'unpaid'")
    @Column(name = "payment_status")
    private String paymentStatus;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at")
    private Instant updatedAt;

}
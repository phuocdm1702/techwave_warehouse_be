package com.example.warehouse_be.entity.InvoiceEntity;

import com.example.warehouse_be.entity.ProductEntity.ProductItem;
import com.example.warehouse_be.entity.Warehouse;
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
@Table(name = "inventory_transaction")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class InventoryTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Integer id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    private ProductItem item;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "warehouse_id", referencedColumnName = "warehouse_id")
    private Warehouse warehouse;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "reference_type")
    private String referenceType;

    @Column(name = "reference_number")
    private String referenceNumber;

    @Column(name = "reference_id")
    private Integer referenceId;

    @Column(name = "unit_cost")
    private BigDecimal unitCost;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "created_by")
    private Integer createdBy;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "transaction_date")
    private Instant transactionDate;

    @Column(name = "notes")
    private String notes;

}
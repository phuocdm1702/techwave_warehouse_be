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
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "inventory")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Integer id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    private ProductItem item;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "warehouse_id", referencedColumnName = "warehouse_id")
    private Warehouse warehouse;

    @ColumnDefault("0.00")
    @Column(name = "quantity")
    private BigDecimal quantity;

    @ColumnDefault("0.00")
    @Column(name = "reserved_quantity")
    private BigDecimal reservedQuantity;

    @ColumnDefault("0.00")
    @Column(name = "available_quantity")
    private BigDecimal availableQuantity;

    @Column(name = "inventory_date")
    private LocalDate inventoryDate;

    @Column(name = "batch_number")
    private String batchNumber;

    @Column(name = "batch_info")
    private String batchInfo;

    @Column(name = "notes")
    private String notes;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "last_updated")
    private Instant lastUpdated;

}
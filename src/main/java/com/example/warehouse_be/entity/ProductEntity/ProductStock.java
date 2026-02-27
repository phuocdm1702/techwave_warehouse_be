package com.example.warehouse_be.entity.ProductEntity;

import com.example.warehouse_be.entity.Area;
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
@Table(name = "product_stock")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ProductStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    private Integer id;

    @Column(name = "stock_code")
    private String stockCode;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "item_id",referencedColumnName = "item_id")
    private ProductItem item;

    @Column(name = "rfid_tag")
    private String rfidTag;

    @Column(name = "actual_length")
    private BigDecimal actualLength;

    @Column(name = "actual_weight")
    private BigDecimal actualWeight;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "warehouse_id", referencedColumnName = "warehouse_id")
    private Warehouse warehouse;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "area_id", referencedColumnName = "area_id")
    private Area area;

    @Column(name = "shelf_location", length = 50)
    private String shelfLocation;

    @ColumnDefault("'in_stock'")
    @Column(name = "status")
    private String status;

    @Column(name = "manufacture_date")
    private LocalDate manufactureDate;

    @Column(name = "received_date")
    private LocalDate receivedDate;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(name = "notes")
    private String notes;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

}
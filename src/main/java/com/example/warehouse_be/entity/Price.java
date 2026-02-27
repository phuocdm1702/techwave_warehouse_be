package com.example.warehouse_be.entity;

import com.example.warehouse_be.entity.ProductEntity.ProductItem;
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
@Table(name = "price")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_id")
    private Integer id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    private ProductItem item;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @ColumnDefault("'retail'")
    @Column(name = "price_type")
    private String priceType;

    @Column(name = "effective_date")
    private LocalDate effectiveDate;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @ColumnDefault("1")
    @Column(name = "is_current")
    private Boolean isCurrent;

    @Column(name = "notes")
    private String notes;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

}
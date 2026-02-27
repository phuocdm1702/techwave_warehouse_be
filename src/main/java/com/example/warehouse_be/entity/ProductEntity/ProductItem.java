package com.example.warehouse_be.entity.ProductEntity;

import com.example.warehouse_be.entity.TechnicalSpec;
import com.example.warehouse_be.entity.Unit;
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
@Table(name = "product_item")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Integer id;

    @Column(name = "item_code")
    private String itemCode;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "detail_id", referencedColumnName = "detail_id")
    private ProductDetail detail;

    @Column(name = "size_dimension", length = 50)
    private String sizeDimension;

    @Column(name = "width", precision = 10, scale = 2)
    private BigDecimal width;

    @Column(name = "length_per_unit", precision = 10, scale = 2)
    private BigDecimal lengthPerUnit;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "unit_id", referencedColumnName = "unit_id")
    private Unit unit;

    @Column(name = "weight_per_unit", precision = 10, scale = 2)
    private BigDecimal weightPerUnit;

    @Column(name = "internal_code", length = 50)
    private String internalCode;

    @Column(name = "manufacturer_code", length = 100)
    private String manufacturerCode;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "primary_spec_id", referencedColumnName = "spec_id")
    private TechnicalSpec primarySpec;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "secondary_spec_id", referencedColumnName = "spec_id")
    private TechnicalSpec secondarySpec;

    @ColumnDefault("0")
    @Column(name = "min_stock")
    private Integer minStock;

    @ColumnDefault("10000")
    @Column(name = "max_stock")
    private Integer maxStock;

    @ColumnDefault("0")
    @Column(name = "reorder_point")
    private Integer reorderPoint;

    @ColumnDefault("1")
    @Column(name = "is_active")
    private Boolean isActive;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at")
    private Instant updatedAt;

}
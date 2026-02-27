package com.example.warehouse_be.entity.InvoiceEntity;

import com.example.warehouse_be.entity.ProductEntity.ProductItem;
import com.example.warehouse_be.entity.ProductEntity.ProductStock;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "invoice_detail")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class InvoiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id")
    private Integer id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "invoice_id", referencedColumnName = "invoice_id")
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    private ProductItem item;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "stock_id", referencedColumnName = "stock_id")
    private ProductStock stock;

    @Column(name = "item_code")
    private String itemCode;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "detail_name")
    private String detailName;

    @Column(name = "size_dimension")
    private String sizeDimension;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @ColumnDefault("0.00")
    @Column(name = "discount_percent")
    private BigDecimal discountPercent;

    @ColumnDefault("0.00")
    @Column(name = "discount_amount")
    private BigDecimal discountAmount;

    @ColumnDefault("0.00")
    @Column(name = "tax_percent")
    private BigDecimal taxPercent;

    @ColumnDefault("0.00")
    @Column(name = "tax_amount")
    private BigDecimal taxAmount;

    @ColumnDefault("0.00")
    @Column(name = "line_total")
    private BigDecimal lineTotal;

    @Column(name = "notes")
    private String notes;

}
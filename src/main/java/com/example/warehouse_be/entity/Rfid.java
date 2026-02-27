package com.example.warehouse_be.entity;

import com.example.warehouse_be.entity.ProductEntity.ProductStock;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "rfid")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Rfid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rfid_id")
    private Integer id;

    @Column(name = "rfid_tag")
    private String rfidTag;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "stock_id", referencedColumnName = "stock_id")
    private ProductStock stock;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "assigned_date")
    private Instant assignedDate;

    @Column(name = "unassigned_date")
    private Instant unassignedDate;

    @ColumnDefault("1")
    @Column(name = "is_active")
    private Boolean isActive;

}
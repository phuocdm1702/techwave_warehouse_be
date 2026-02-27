package com.example.warehouse_be.entity.InvoiceEntity;

import com.example.warehouse_be.entity.EmployeeEntity.Employee;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "invoice_history")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class InvoiceHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private Integer id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "invoice_id", referencedColumnName = "invoice_id")
    private Invoice invoice;

    @Column(name = "action")
    private String action;

    @Column(name = "old_status")
    private String oldStatus;

    @Column(name = "new_status")
    private String newStatus;

    @Column(name = "changes")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> changes;

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
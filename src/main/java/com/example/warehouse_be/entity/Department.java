package com.example.warehouse_be.entity;

import com.example.warehouse_be.entity.EmployeeEntity.Employee;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "department")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Integer id;

    @Column(name = "department_code")
    private String departmentCode;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "manager_id", referencedColumnName = "manager_id")
    private Employee manager;

    @ColumnDefault("1")
    @Column(name = "is_active")
    private Boolean isActive;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

}
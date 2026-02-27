package com.example.warehouse_be.entity.EmployeeEntity;

import com.example.warehouse_be.entity.Department;
import com.example.warehouse_be.entity.Position;
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
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer id;

    @Column(name = "employee_code")
    private String employeeCode;

    @Column(name = "full_name")
    private String fullName;

    @ColumnDefault("'Other'")
    @Column(name = "gender")
    private String gender;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "id_card")
    private String idCard;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    private Department department;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "position_id", referencedColumnName = "position_id")
    private Position position;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "manager_id", referencedColumnName = "employee_id")
    private Employee manager;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    @Column(name = "termination_date")
    private LocalDate terminationDate;

    @Column(name = "base_salary", precision = 15, scale = 2)
    private BigDecimal baseSalary;

    @Column(name = "bank_account", length = 50)
    private String bankAccount;

    @Column(name = "bank_name", length = 100)
    private String bankName;

    @ColumnDefault("'working'")
    @Column(name = "status")
    private String status;

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
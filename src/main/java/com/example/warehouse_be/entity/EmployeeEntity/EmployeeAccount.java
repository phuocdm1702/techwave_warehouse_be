package com.example.warehouse_be.entity.EmployeeEntity;

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
@Table(name = "employee_account")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class EmployeeAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Integer id;

    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

    @Column(name = "username")
    private String username;

    @Column(name = "password_hash")
    private String passwordHash;

    @ColumnDefault("'viewer'")
    @Column(name = "role")
    private String role;

    @Column(name = "permissions")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> permissions;

    @Column(name = "last_login")
    private Instant lastLogin;

    @Column(name = "last_login_ip", length = 45)
    private String lastLoginIp;

    @ColumnDefault("0")
    @Column(name = "login_attempts")
    private Integer loginAttempts;

    @Column(name = "locked_until")
    private Instant lockedUntil;

    @ColumnDefault("1")
    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "password_changed_at")
    private Instant passwordChangedAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at")
    private Instant updatedAt;

}
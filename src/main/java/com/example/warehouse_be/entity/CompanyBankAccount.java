package com.example.warehouse_be.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "company_bank_account")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CompanyBankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_bank_id")
    private Integer id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "bank_id", referencedColumnName = "bank_id")
    private Bank bank;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "branch")
    private String branch;

    @ColumnDefault("0")
    @Column(name = "is_default")
    private Boolean isDefault;

    @ColumnDefault("1")
    @Column(name = "is_active")
    private Boolean isActive;

    @Lob
    @Column(name = "notes")
    private String notes;

}
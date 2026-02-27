package com.example.warehouse_be.entity.CustomerEntity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "customer_contact")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CustomerContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Integer id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "positions")
    private String positions;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @ColumnDefault("0")
    @Column(name = "is_primary")
    private Boolean isPrimary;

    @Lob
    @Column(name = "notes")
    private String notes;

    @ColumnDefault("1")
    @Column(name = "is_active")
    private Boolean isActive;

}
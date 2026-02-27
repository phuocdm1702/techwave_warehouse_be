package com.example.warehouse_be.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "technical_spec")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TechnicalSpec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spec_id")
    private Integer id;

    @Column(name = "spec_code")
    private String specCode;

    @Column(name = "spec_name")
    private String specName;

    @Column(name = "description")
    private String description;

}
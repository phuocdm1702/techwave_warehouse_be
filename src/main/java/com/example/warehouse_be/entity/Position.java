package com.example.warehouse_be.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "positions")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Integer id;

    @Column(name = "position_code")
    private String positionCode;

    @Column(name = "position_name")
    private String positionName;

    @Column(name = "position_level")
    private Integer positionLevel;

    @Column(name = "description")
    private String description;

}
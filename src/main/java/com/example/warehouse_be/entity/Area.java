package com.example.warehouse_be.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "area")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "area_id")
    private Integer id;

    @Column(name = "area_code")
    private String areaCode;

    @Column(name = "area_name")
    private String areaName;

    @Column(name = "location")
    private String location;

    @Column(name = "relay_number")
    private Integer relayNumber;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "board_id", referencedColumnName = "board_id")
    private Board board;

}
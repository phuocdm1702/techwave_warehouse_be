package com.example.warehouse_be.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Area {
    private Integer areaId;
    private String areaCode;
    private String areaName;
    private String location;
    private Integer relayNumber;
    private Board board;

}

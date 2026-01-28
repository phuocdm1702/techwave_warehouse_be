package com.example.warehouse_be.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Board {
    private Integer boardId;
    private String ip;
    private Integer port;
    private Integer serialNumber;

    public Board(String ip, int port, int serialNumber) {
        this.ip = ip;
        this.port = port;
        this.serialNumber = serialNumber;
    }
}

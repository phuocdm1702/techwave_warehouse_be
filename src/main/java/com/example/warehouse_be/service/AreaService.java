package com.example.warehouse_be.service;

import com.example.warehouse_be.entity.Board;
import com.example.warehouse_be.entity.Area;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AreaService {
    private List<Area> areaList = new ArrayList<>();

    @Autowired
    private BoardService boardService;

    public AreaService() {
        // Không làm gì trong constructor
    }

    @PostConstruct
    public void init() {
        initData();
    }

    private void initData() {
        // 1. Lấy danh sách bảng mạch
        List<Board> boards = boardService.getBoardList();

        // 2. Tạo khu vực với bảng mạch
        areaList.add(Area.builder()
                .areaId(1)
                .areaCode("KV-01")
                .areaName("Khu vải Cotton")
                .location("Tầng 1, Ô 1-10")
                .relayNumber(1)  // Relay số 1 trên board
                .board(boards.get(0))
                .build());

        areaList.add(Area.builder()
                .areaId(2)
                .areaCode("KV-02")
                .areaName("Khu vải Kaki/Jeans")
                .location("Tầng 1-2, Ô 11-25")
                .relayNumber(2)  // Relay số 1 trên board
                .board(boards.get(1))
                .build());

        areaList.add(Area.builder()
                .areaId(3)
                .areaCode("KV-03")
                .areaName("Khu vải Lụa/Voan")
                .location("Tầng 2, Ô 26-35")
                .relayNumber(3)  // Relay số 1 trên board
                .board(boards.get(2))
                .build());

        areaList.add(Area.builder()
                .areaId(4)
                .areaCode("KV-04")
                .areaName("Khu vải Len/Nỉ")
                .location("Tầng 2-3, Ô 36-50")
                .relayNumber(4)  // Relay số 1 trên board
                .board(boards.get(3))
                .build());

        areaList.add(Area.builder()
                .areaId(5)
                .areaCode("KV-05")
                .areaName("Khu vải đặc biệt")
                .location("Tầng 3, Ô 51-60")
                .relayNumber(5)  // Relay số 1 trên board
                .board(boards.get(4))
                .build());
    }

    public List<Area> getAreaList() {
        return areaList;
    }

    public Area getKhuVucById(Integer id) {
        return areaList.stream()
                .filter(k -> k.getAreaId().equals(id))
                .findFirst()
                .orElse(null);
    }
}

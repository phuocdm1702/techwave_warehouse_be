package com.example.warehouse_be.service;

import com.example.warehouse_be.entity.Board;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    private List<Board> boardList = new ArrayList<>();

    public BoardService() {
        initData();
    }

    private void initData() {
        boardList.add(Board.builder()
                .boardId(1)
                .ip("192.168.2.229")
                .port(60000)
                .serialNumber(175111864)
                .build());

        boardList.add(Board.builder()
                .boardId(2)
                .ip("192.168.1.101")
                .port(60001)
                .serialNumber(175111865)
                .build());

        boardList.add(Board.builder()
                .boardId(3)
                .ip("192.168.1.102")
                .port(60002)
                .serialNumber(175111866)
                .build());

        boardList.add(Board.builder()
                .boardId(4)
                .ip("192.168.1.103")
                .port(60003)
                .serialNumber(175111867)
                .build());

        boardList.add(Board.builder()
                .boardId(5)
                .ip("192.168.1.104")
                .port(60004)
                .serialNumber(175111868)
                .build());

        boardList.add(Board.builder()
                .boardId(6)
                .ip("192.168.2.50")
                .port(50000)
                .serialNumber(175111869)
                .build());

        boardList.add(Board.builder()
                .boardId(7)
                .ip("192.168.2.51")
                .port(50001)
                .serialNumber(175111870)
                .build());

        boardList.add(Board.builder()
                .boardId(8)
                .ip("10.0.0.100")
                .port(8080)
                .serialNumber(175111871)
                .build());

        boardList.add(Board.builder()
                .boardId(9)
                .ip("10.0.0.101")
                .port(8081)
                .serialNumber(175111872)
                .build());

        boardList.add(Board.builder()
                .boardId(10)
                .ip("172.16.0.10")
                .port(9000)
                .serialNumber(175111873)
                .build());
    }

    public List<Board> getBoardList(){
        return boardList;
    }

    public Board getBangMachById(Integer id) {
        return boardList.stream()
                .filter(bm -> bm.getBoardId().equals(id))
                .findFirst()
                .orElse(null);
    }
}

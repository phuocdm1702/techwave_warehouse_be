package com.example.warehouse_be.service;

import com.example.warehouse_be.entity.Board;
import com.example.warehouse_be.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;
    private List<Board> boardList = new ArrayList<>();
    public List<Board> getAllBoards(){
        return boardRepository.findAll();
    }
    public List<Board> getBoardList(){
        return boardRepository.findAll();
    }

    public Board getBangMachById(Integer id) {
        return boardList.stream()
                .filter(bm -> bm.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}

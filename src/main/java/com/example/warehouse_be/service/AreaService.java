package com.example.warehouse_be.service;

import com.example.warehouse_be.entity.Area;
import com.example.warehouse_be.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AreaService {
    private List<Area> areaList = new ArrayList<>();
    @Autowired
    private AreaRepository areaRepository;
    @Autowired
    private BoardService boardService;

    public List<Area> getAllAreas(){
        return areaRepository.findAll();
    }

    public List<Area> getAreaList() {
        return areaRepository.findAll();
    }

    public Area getKhuVucById(Integer id) {
        return areaList.stream()
                .filter(k -> k.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}

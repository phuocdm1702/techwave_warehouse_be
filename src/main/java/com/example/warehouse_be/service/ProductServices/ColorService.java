package com.example.warehouse_be.service.ProductServices;

import com.example.warehouse_be.entity.ProductEntity.Color;
import com.example.warehouse_be.repository.ProductRepositorys.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColorService {
    @Autowired
    private ColorRepository colorRepository;
    public List<Color> getAllColor(){
        return colorRepository.findAll();
    }
    private List<Color> colorList = new ArrayList<>();

    public List<Color> getColorList() {
        return colorList;
    }

    public Color getColorById(Integer id) {
        return colorRepository.findById(id).get();
    }

    public Color getColorByCode(String code) {
        return colorRepository.findColorByColorCode(code);
    }
}

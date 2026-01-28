package com.example.warehouse_be.service.ProductService;
import com.example.warehouse_be.entity.ProductEntity.Weight;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeightService {
    private List<Weight> weightList = new ArrayList<>();

    @PostConstruct
    public void init() {
        initData();
    }

    private void initData() {
        weightList.add(Weight.builder()
                .weightId(1)
                .weightCode("WT001")
                .value(5.0)
                .unit("kg")
                .build());

        weightList.add(Weight.builder()
                .weightId(2)
                .weightCode("WT002")
                .value(10.0)
                .unit("kg")
                .build());

        weightList.add(Weight.builder()
                .weightId(3)
                .weightCode("WT003")
                .value(15.0)
                .unit("kg")
                .build());

        weightList.add(Weight.builder()
                .weightId(4)
                .weightCode("WT004")
                .value(20.0)
                .unit("kg")
                .build());

        weightList.add(Weight.builder()
                .weightId(5)
                .weightCode("WT005")
                .value(25.0)
                .unit("kg")
                .build());

        weightList.add(Weight.builder()
                .weightId(6)
                .weightCode("WT006")
                .value(30.0)
                .unit("kg")
                .build());

        weightList.add(Weight.builder()
                .weightId(7)
                .weightCode("WT007")
                .value(50.0)
                .unit("kg")
                .build());

        weightList.add(Weight.builder()
                .weightId(8)
                .weightCode("WT008")
                .value(100.0)
                .unit("kg")
                .build());
    }

    public List<Weight> getWeightList() {
        return weightList;
    }

    public Weight getWeightById(Integer id) {
        return weightList.stream()
                .filter(w -> w.getWeightId().equals(id))
                .findFirst()
                .orElse(null);
    }
}

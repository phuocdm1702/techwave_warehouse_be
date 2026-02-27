package com.example.warehouse_be.service.ProductServices;
import com.example.warehouse_be.entity.Unit;
import com.example.warehouse_be.repository.ProductRepositorys.WeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeightService {
    @Autowired
    private WeightRepository weightRepository;
    private List<Unit> weightList = new ArrayList<>();

    public List<Unit> getAllWeights(){
        return weightRepository.findAll();
    }
    public List<Unit> getWeightList() {
        return weightList;
    }

    public Unit getWeightById(Integer id) {
        return weightList.stream()
                .filter(w -> w.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}

package com.example.warehouse_be.service.ProductServices;

import com.example.warehouse_be.entity.ProductEntity.Material;
import com.example.warehouse_be.repository.ProductRepositorys.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MaterialService {
    @Autowired
    private MaterialRepository materialRepository;

    public List<Material> getAllMaterials() {
        return materialRepository.findAll();
    }

    private List<Material> materialList = new ArrayList<>();


    public Material getMaterialById(Integer id) {
        return materialRepository.findById(id).get();
    }
}

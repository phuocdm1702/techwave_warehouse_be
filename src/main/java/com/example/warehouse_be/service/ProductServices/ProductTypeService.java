package com.example.warehouse_be.service.ProductServices;

import com.example.warehouse_be.entity.ProductEntity.ProductType;
import com.example.warehouse_be.repository.ProductRepositorys.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepository;

    public List<ProductType> getProductTypeList() {
        return productTypeRepository.findAll();
    }

    public ProductType getProductTypeById(Integer id) {
        return productTypeRepository.findById(id).orElse(null);
    }
}

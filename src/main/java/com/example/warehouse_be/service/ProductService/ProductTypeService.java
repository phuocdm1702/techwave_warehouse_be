package com.example.warehouse_be.service.ProductService;

import com.example.warehouse_be.entity.ProductEntity.ProductType;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@Service
public class ProductTypeService {
    private List<ProductType> productTypeList = new ArrayList<>();

    @PostConstruct
    public void init() {
        initData();
    }

    private void initData() {
        productTypeList.add(new ProductType(1, 1001, "Vải Cotton"));
        productTypeList.add(new ProductType(2, 1002, "Vải Kaki/Jeans"));
        productTypeList.add(new ProductType(3, 1003, "Vải Lụa/Voan"));
        productTypeList.add(new ProductType(4, 1004, "Vải Len/Nỉ"));
        productTypeList.add(new ProductType(5, 1005, "Vải Đặc Biệt"));
        productTypeList.add(new ProductType(6, 1006, "Vải Thể Thao"));
        productTypeList.add(new ProductType(7, 1007, "Vải Công Nghiệp"));
        productTypeList.add(new ProductType(8, 1008, "Vải Trang Trí"));
    }

    public List<ProductType> getProductTypeList() {
        return productTypeList;
    }

    public ProductType getProductTypeById(Integer id) {
        return productTypeList.stream()
                .filter(pt -> pt.getProductTypeId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public ProductType getProductTypeByCode(Integer code) {
        return productTypeList.stream()
                .filter(pt -> pt.getProductTypeCode().equals(code))
                .findFirst()
                .orElse(null);
    }
}

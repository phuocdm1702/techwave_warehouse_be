package com.example.warehouse_be.controller;

import com.example.warehouse_be.model.response.ProductDetailResponse;
import com.example.warehouse_be.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/detail-product")
public class DetailProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDetailResponse> getAllDetailProduct() {
        return productService.getAllProductDetails();
    }

    @GetMapping("/{id}")
    public ProductDetailResponse getDetailProductById(@PathVariable Integer id) {
        return productService.getProductDetailById(id);
    }

    @GetMapping("/by-area/{areaId}")
    public List<ProductDetailResponse> getProductInAreas(@PathVariable Integer areaId) {
        return productService.getProductDetailsByAreaId(areaId);
    }
}

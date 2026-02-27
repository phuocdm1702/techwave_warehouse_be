package com.example.warehouse_be.service.ProductServices;

import com.example.warehouse_be.entity.ProductEntity.Product;
import com.example.warehouse_be.model.response.AreaProductResponse;
import com.example.warehouse_be.model.response.ProductDetailResponse;
import com.example.warehouse_be.repository.ProductRepositorys.ProductRepository;
import com.example.warehouse_be.repository.RfidRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RfidRepository rfidRepository;

    public List<ProductDetailResponse> getAll(){
        List<com.example.warehouse_be.entity.Rfid> allRfids = rfidRepository.findAll();
        return productRepository.findAll()
                .stream()
                .map(product -> {
                    ProductDetailResponse response = new ProductDetailResponse(product);
                    List<String> tags = allRfids.stream()
                            .filter(rfid -> rfid.getStock() != null
                                    && rfid.getStock().getItem() != null
                                    && rfid.getStock().getItem().getDetail() != null
                                    && rfid.getStock().getItem().getDetail().getProduct() != null
                                    && rfid.getStock().getItem().getDetail().getProduct().getId().equals(product.getId()))
                            .map(com.example.warehouse_be.entity.Rfid::getRfidTag)
                            .toList();
                    response.setRfidTags(tags);
                    return response;
                })
                .toList();
    }

    public Product addProduct(Product product) {
        if (product.getCreatedAt() == null) {
            product.setCreatedAt(java.time.Instant.now());
        }
        return productRepository.save(product);
    }

    public List<ProductDetailResponse> getAllProductDetails() {
        List<com.example.warehouse_be.entity.Rfid> allRfids = rfidRepository.findAll();
        return productRepository.findAll().stream()
                .map(product -> {
                    ProductDetailResponse response = new ProductDetailResponse(product);
                    List<String> tags = allRfids.stream()
                            .filter(rfid -> rfid.getStock() != null
                                    && rfid.getStock().getItem() != null
                                    && rfid.getStock().getItem().getDetail() != null
                                    && rfid.getStock().getItem().getDetail().getProduct() != null
                                    && rfid.getStock().getItem().getDetail().getProduct().getId().equals(product.getId()))
                            .map(com.example.warehouse_be.entity.Rfid::getRfidTag)
                            .toList();
                    response.setRfidTags(tags);
                    return response;
                })
                .toList();
    }

    public ProductDetailResponse getProductDetailById(Integer id) {
        return productRepository.findById(id)
                .map(product -> {
                    ProductDetailResponse response = new ProductDetailResponse(product);
                    List<String> tags = rfidRepository.findAll().stream()
                            .filter(rfid -> rfid.getStock() != null
                                    && rfid.getStock().getItem() != null
                                    && rfid.getStock().getItem().getDetail() != null
                                    && rfid.getStock().getItem().getDetail().getProduct() != null
                                    && rfid.getStock().getItem().getDetail().getProduct().getId().equals(product.getId()))
                            .map(com.example.warehouse_be.entity.Rfid::getRfidTag)
                            .toList();
                    response.setRfidTags(tags);
                    return response;
                })
                .orElse(null);
    }

    public List<ProductDetailResponse> getProductDetailsByAreaId(Integer areaId) {
        return List.of();
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product findByProductCode(String productCode) {
        return productRepository.findAll().stream()
                .filter(product -> product.getProductCode().equalsIgnoreCase(productCode))
                .findFirst()
                .orElse(null);
    }

    public List<AreaProductResponse> getProductsGroupedByArea() {
        List<com.example.warehouse_be.entity.Rfid> allRfids = rfidRepository.findAll();
        Map<String, List<Product>> grouped = productRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(p -> "Chưa phân loại"));

        return grouped.values().stream()
                .map(products -> {
                    List<ProductDetailResponse> productDetails = products.stream()
                            .map(product -> {
                                ProductDetailResponse response = new ProductDetailResponse(product);
                                List<String> tags = allRfids.stream()
                                        .filter(rfid -> rfid.getStock() != null
                                                && rfid.getStock().getItem() != null
                                                && rfid.getStock().getItem().getDetail() != null
                                                && rfid.getStock().getItem().getDetail().getProduct() != null
                                                && rfid.getStock().getItem().getDetail().getProduct().getId().equals(product.getId()))
                                        .map(com.example.warehouse_be.entity.Rfid::getRfidTag)
                                        .toList();
                                response.setRfidTags(tags);
                                return response;
                            })
                            .toList();
                    return new AreaProductResponse(null, productDetails);
                })
                .toList();
    }
}

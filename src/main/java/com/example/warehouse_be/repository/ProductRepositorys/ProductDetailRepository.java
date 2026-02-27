package com.example.warehouse_be.repository.ProductRepositorys;

import com.example.warehouse_be.entity.ProductEntity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Integer> {
}

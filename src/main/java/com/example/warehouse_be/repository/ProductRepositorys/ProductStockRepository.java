package com.example.warehouse_be.repository.ProductRepositorys;

import com.example.warehouse_be.entity.ProductEntity.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductStockRepository extends JpaRepository<ProductStock, Integer> {
}

package com.example.warehouse_be.repository.ProductRepositorys;

import com.example.warehouse_be.entity.ProductEntity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}

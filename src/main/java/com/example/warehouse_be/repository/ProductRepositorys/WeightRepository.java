package com.example.warehouse_be.repository.ProductRepositorys;

import com.example.warehouse_be.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeightRepository extends JpaRepository<Unit, Integer> {
}

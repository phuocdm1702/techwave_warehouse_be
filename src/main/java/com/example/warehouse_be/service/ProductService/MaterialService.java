package com.example.warehouse_be.service.ProductService;

import com.example.warehouse_be.entity.ProductEntity.Material;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@Service
public class MaterialService {
    private List<Material> materialList = new ArrayList<>();

    @PostConstruct
    public void init() {
        initData();
    }

    private void initData() {
        materialList.add(Material.builder()
                .materialId(1)
                .materialCode("MAT001")
                .materialName("Cotton 100%")
                .description("Vải cotton nguyên chất 100%")
                .build());

        materialList.add(Material.builder()
                .materialId(2)
                .materialCode("MAT002")
                .materialName("Cotton pha Polyester")
                .description("65% cotton, 35% polyester")
                .build());

        materialList.add(Material.builder()
                .materialId(3)
                .materialCode("MAT003")
                .materialName("Lụa tơ tằm")
                .description("Lụa cao cấp từ tơ tằm tự nhiên")
                .build());

        materialList.add(Material.builder()
                .materialId(4)
                .materialCode("MAT004")
                .materialName("Len cashmere")
                .description("Len cao cấp từ cashmere")
                .build());

        materialList.add(Material.builder()
                .materialId(5)
                .materialCode("MAT005")
                .materialName("Denim")
                .description("Vải denim chất lượng cao")
                .build());

        materialList.add(Material.builder()
                .materialId(6)
                .materialCode("MAT006")
                .materialName("Polyester")
                .description("Vải polyester chính hãng")
                .build());

        materialList.add(Material.builder()
                .materialId(7)
                .materialCode("MAT007")
                .materialName("Vải da PU")
                .description("Vải da PU cao cấp")
                .build());

        materialList.add(Material.builder()
                .materialId(8)
                .materialCode("MAT008")
                .materialName("Vải nỉ")
                .description("Vải nỉ mềm mại, ấm áp")
                .build());
    }

    public List<Material> getMaterialList() {
        return materialList;
    }

    public Material getMaterialById(Integer id) {
        return materialList.stream()
                .filter(m -> m.getMaterialId().equals(id))
                .findFirst()
                .orElse(null);
    }
}

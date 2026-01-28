package com.example.warehouse_be.service.ProductService;

import com.example.warehouse_be.entity.ProductEntity.Size;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@Service
public class SizeService {
    private List<Size> sizeList = new ArrayList<>();

    @PostConstruct
    public void init() {
        initData();
    }

    private void initData() {
        // Kích thước cuộn vải tiêu chuẩn
        sizeList.add(Size.builder()
                .sizeId(1)
                .sizeCode("SIZE001")
                .sizeName("Cuộn nhỏ")
                .length(50.0)
                .width(1.5)
                .height(0.5)
                .unit("m")
                .build());

        sizeList.add(Size.builder()
                .sizeId(2)
                .sizeCode("SIZE002")
                .sizeName("Cuộn trung")
                .length(100.0)
                .width(1.5)
                .height(0.8)
                .unit("m")
                .build());

        sizeList.add(Size.builder()
                .sizeId(3)
                .sizeCode("SIZE003")
                .sizeName("Cuộn lớn")
                .length(200.0)
                .width(1.5)
                .height(1.2)
                .unit("m")
                .build());

        sizeList.add(Size.builder()
                .sizeId(4)
                .sizeCode("SIZE004")
                .sizeName("Cuộn siêu lớn")
                .length(500.0)
                .width(2.0)
                .height(1.5)
                .unit("m")
                .build());

        sizeList.add(Size.builder()
                .sizeId(5)
                .sizeCode("SIZE005")
                .sizeName("Tấm vải")
                .length(3.0)
                .width(1.5)
                .height(0.02)
                .unit("m")
                .build());
    }

    public List<Size> getSizeList() {
        return sizeList;
    }

    public Size getSizeById(Integer id) {
        return sizeList.stream()
                .filter(s -> s.getSizeId().equals(id))
                .findFirst()
                .orElse(null);
    }
}

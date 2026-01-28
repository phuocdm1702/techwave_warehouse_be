package com.example.warehouse_be.service.ProductService;

import com.example.warehouse_be.entity.ProductEntity.Color;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColorService {
    private List<Color> colorList = new ArrayList<>();

    @PostConstruct
    public void init() {
        initData();
    }

    private void initData() {
        colorList.add(Color.builder()
                .colorId(1)
                .colorCode("COL001")
                .colorName("Trắng")
                .hexValue("#FFFFFF")
                .build());

        colorList.add(Color.builder()
                .colorId(2)
                .colorCode("COL002")
                .colorName("Đen")
                .hexValue("#000000")
                .build());

        colorList.add(Color.builder()
                .colorId(3)
                .colorCode("COL003")
                .colorName("Xanh dương")
                .hexValue("#0000FF")
                .build());

        colorList.add(Color.builder()
                .colorId(4)
                .colorCode("COL004")
                .colorName("Đỏ")
                .hexValue("#FF0000")
                .build());

        colorList.add(Color.builder()
                .colorId(5)
                .colorCode("COL005")
                .colorName("Xanh lá")
                .hexValue("#00FF00")
                .build());

        colorList.add(Color.builder()
                .colorId(6)
                .colorCode("COL006")
                .colorName("Vàng")
                .hexValue("#FFFF00")
                .build());

        colorList.add(Color.builder()
                .colorId(7)
                .colorCode("COL007")
                .colorName("Xám")
                .hexValue("#808080")
                .build());

        colorList.add(Color.builder()
                .colorId(8)
                .colorCode("COL008")
                .colorName("Nâu")
                .hexValue("#A52A2A")
                .build());
    }

    public List<Color> getColorList() {
        return colorList;
    }

    public Color getColorById(Integer id) {
        return colorList.stream()
                .filter(c -> c.getColorId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Color getColorByCode(String code) {
        return colorList.stream()
                .filter(c -> c.getColorCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }
}

package com.example.warehouse_be.model.response;


import com.example.warehouse_be.entity.Area;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AreaProductResponse {
    private Integer areaId;
    private String areaCode;
    private String areaName;
    private String location;
    private List<ProductDetailResponse> products;

    public AreaProductResponse(Area area, List<ProductDetailResponse> products) {
        if (area != null) {
            this.areaId = area.getId();
            this.areaCode = area.getAreaCode();
            this.areaName = area.getAreaName();
            this.location = area.getLocation();
        } else {
            this.areaName = "Chưa phân loại";
        }
        this.products = products;
    }
}

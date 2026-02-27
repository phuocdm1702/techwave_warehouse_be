package com.example.warehouse_be.model.response;

import com.example.warehouse_be.entity.Rfid;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RfidandproductResponse {
    private Integer id;
    private String rfidTag;
    private String productCode;
    private String productName;

    public RfidandproductResponse(Rfid rfid) {
        this.id = rfid.getId();
        this.rfidTag = rfid.getRfidTag();
        if (rfid.getStock() != null
                && rfid.getStock().getItem() != null
                && rfid.getStock().getItem().getDetail() != null
                && rfid.getStock().getItem().getDetail().getProduct() != null) {
            this.productCode = rfid.getStock().getItem().getDetail().getProduct().getProductCode();
            this.productName = rfid.getStock().getItem().getDetail().getProduct().getProductName();
        }
    }
}

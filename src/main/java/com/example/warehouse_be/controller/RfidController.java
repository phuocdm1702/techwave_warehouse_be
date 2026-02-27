package com.example.warehouse_be.controller;

import com.example.warehouse_be.model.response.RfidandproductResponse;
import com.example.warehouse_be.service.RfidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rfid")
public class RfidController {
    @Autowired
    private RfidService rfidService;

    @GetMapping
    public List<RfidandproductResponse> getRfidandproduct() {
        return rfidService.getRfidList();
    }
}

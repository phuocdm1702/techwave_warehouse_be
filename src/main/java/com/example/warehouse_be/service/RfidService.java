package com.example.warehouse_be.service;

import com.example.warehouse_be.model.response.RfidandproductResponse;
import com.example.warehouse_be.repository.RfidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RfidService {
    @Autowired
    private RfidRepository rfidRepository;

    public List<RfidandproductResponse> getRfidList(){
        return rfidRepository.findAll()
                .stream()
                .map(RfidandproductResponse::new)
                .toList()
                ;
    }
}

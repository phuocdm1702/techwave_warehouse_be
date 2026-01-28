package com.example.warehouse_be.config;

import com.example.warehouse_be.entity.Board;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Board boardConfiguration() {
        // These values should ideally come from application.properties
        // For now, hardcoding them as they were in the original InventoryService
        String ip = "255.255.255.255";
        int port = 60000;
        int serialNumber = 175111864; // SN: 0x0A6FFEB8
        return new Board(ip, port, serialNumber);
    }
}

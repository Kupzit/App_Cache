package com.example.appcache_testing_runtime_lk.controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.appcache_testing_runtime_lk.service.SalesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SalesController {

    private final SalesService salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping("/sales")
    public List<Map<String, Object>> getSales() {
        return salesService.getSalesWithCache();
    }
}
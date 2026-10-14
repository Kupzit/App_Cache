package com.example.appcache_testing_runtime_lk.controller;

import com.example.appcache_testing_runtime_lk.repository.SalesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SalesController {

    private final SalesRepository salesRepository;

    public SalesController(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    @GetMapping("/sales")
    public List<Map<String, Object>> getSales() {
        return salesRepository.getSalesData();
    }
}
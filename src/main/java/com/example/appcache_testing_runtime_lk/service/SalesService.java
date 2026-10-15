package com.example.appcache_testing_runtime_lk.service;

import com.example.appcache_testing_runtime_lk.repository.SalesRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SalesService {

    private final SalesRepository salesRepository;

    public SalesService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    // Sin cache: siempre consulta SQL Server
    public List<Map<String, Object>> getSalesWithoutCache() {
        return salesRepository.getSalesData();
    }

    // Con cache:
    // Primera llamada -> SQL Server
    // Siguientes llamadas -> RAM
    @Cacheable("salesData")
    public List<Map<String, Object>> getSalesWithCache() {
        return salesRepository.getSalesData();
    }
}
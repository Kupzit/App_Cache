package com.example.appcache_testing_runtime_lk.service;

import com.example.appcache_testing_runtime_lk.repository.SalesRepository;
import org.springframework.cache.annotation.CacheEvict;
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
    // Always goes to SQL Server
    public List<Map<String, Object>> getSalesWithoutCache() {
        return salesRepository.getSalesData();
    }
    // First call goes to SQL Server.
    // Following calls return the saved result from RAM.
    @Cacheable("salesData")
    public List<Map<String, Object>> getSalesWithCache() {
        return salesRepository.getSalesData();
    }
    // Lets us empty the cache whenever we want to repeat the test
    @CacheEvict(value = "salesData", allEntries = true)
    public void clearCache() {
    }
}
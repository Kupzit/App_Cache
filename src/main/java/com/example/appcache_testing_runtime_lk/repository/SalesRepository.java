package com.example.appcache_testing_runtime_lk.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class SalesRepository {

    private final JdbcTemplate jdbcTemplate;

    public SalesRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> getSalesData() {

        System.out.println(">>> CONSULTANDO SQL SERVER");

        String sql = """
                SELECT
                    soh.SalesOrderID,
                    soh.OrderDate,
                    soh.TotalDue,
                    sod.ProductID,
                    p.Name AS ProductName,
                    sod.OrderQty,
                    sod.UnitPrice
                FROM Sales.SalesOrderHeader soh
                INNER JOIN Sales.SalesOrderDetail sod
                    ON soh.SalesOrderID = sod.SalesOrderID
                INNER JOIN Production.Product p
                    ON sod.ProductID = p.ProductID
                """;

        return jdbcTemplate.queryForList(sql);
    }
}
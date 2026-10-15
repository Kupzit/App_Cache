package com.example.appcache_testing_runtime_lk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AppCacheTestingRuntimeLkApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppCacheTestingRuntimeLkApplication.class, args);
    }
}

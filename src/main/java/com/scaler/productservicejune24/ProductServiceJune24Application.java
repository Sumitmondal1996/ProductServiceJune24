package com.scaler.productservicejune24;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableDiscoveryClient
public class ProductServiceJune24Application {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceJune24Application.class, args);
    }

}


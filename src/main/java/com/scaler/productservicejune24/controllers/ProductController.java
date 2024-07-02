package com.scaler.productservicejune24.controllers;

import com.scaler.productservicejune24.models.Product;
import com.scaler.productservicejune24.services.ProductServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    // localhost:8080/products/10

    public ProductServices productServices;
    public ProductController(ProductServices productServices) {
        this.productServices = productServices; // Dependency injection.. Basically FakestoreProductServices is having @Sevice annotations, so that object reference will be passed
    }
    @GetMapping("/{id}")
    public Product getProductbyId(@PathVariable("id") Long id)
    {
        return productServices.getSingleProduct(id);

    }

    public List<Product> getAllProducts()
    {
        return new ArrayList<>();

    }
}

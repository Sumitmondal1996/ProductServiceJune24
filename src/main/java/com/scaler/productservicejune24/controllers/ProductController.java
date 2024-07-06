package com.scaler.productservicejune24.controllers;

import com.scaler.productservicejune24.models.Product;
import com.scaler.productservicejune24.services.ProductServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Product> getProductbyId(@PathVariable("id") Long id)
    {
//        throw new RuntimeException("something went wrong");
       ResponseEntity<Product> res = new ResponseEntity<>(productServices.getSingleProduct(id),
                HttpStatus.OK);
        return res;

    }


    @GetMapping()
    public List<Product> getAllProducts()
    {
        return productServices.getAllProducts();

    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") long id)
    {
        return ;
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") long id,@RequestBody Product product)
    {
        return null;

    }

    @PutMapping ("/{id}")
    public Product replaceProduct(@PathVariable("id") long id,@RequestBody Product product)
    {
        return null;

    }
}

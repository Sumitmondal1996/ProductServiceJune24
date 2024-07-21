package com.scaler.productservicejune24.controllers;

import com.scaler.productservicejune24.dtos.ExceptionDto;
import com.scaler.productservicejune24.exceptions.ProductNotFoundException;
import com.scaler.productservicejune24.models.Product;
import com.scaler.productservicejune24.services.ProductServices;
import org.springframework.beans.factory.annotation.Qualifier;
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
    public ProductController(@Qualifier("selfproductservice") ProductServices productServices) {
        this.productServices = productServices; // Dependency injection.. Basically FakestoreProductServices is having @Sevice annotations, so that object reference will be passed
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductbyId(@PathVariable("id") Long id) throws ProductNotFoundException {
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
        productServices.deleteProduct(id); ;
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") long id,@RequestBody Product product) throws ProductNotFoundException {
        return productServices.updateProduct(id, product);

    }

    @PutMapping ("/{id}")
    public Product replaceProduct(@PathVariable("id") long id,@RequestBody Product product) throws ProductNotFoundException {

        return  null;
    }

    @PostMapping
    public Product addnewproduct(@RequestBody Product product)
    {

        return productServices.addnewproduct(product);

    }

//    @ExceptionHandler(ArithmeticException.class)
//    public ResponseEntity<String> handleNullpointerException()
//    {
//        ResponseEntity res = new ResponseEntity<>(
//                "something went wrong inside controller ", // this will get more priority over GlobalExceptionHandler
//                HttpStatus.NOT_FOUND
//        );
//        return  res;
//
//    }


}

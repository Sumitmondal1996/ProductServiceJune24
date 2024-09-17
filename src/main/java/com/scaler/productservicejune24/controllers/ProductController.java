package com.scaler.productservicejune24.controllers;

import com.scaler.productservicejune24.dtos.ExceptionDto;
import com.scaler.productservicejune24.exceptions.ProductNotFoundException;
import com.scaler.productservicejune24.models.Product;
import com.scaler.productservicejune24.services.ProductServices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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
    public ResponseEntity<Product> getProductbyId(@PathVariable("id") Long id) throws ProductNotFoundException {
//        throw new RuntimeException("something went wrong");
       ResponseEntity<Product> res = new ResponseEntity<>(productServices.getSingleProduct(id),
                HttpStatus.OK);
        return res;

    }


    @GetMapping()
    public Page<Product> getAllProducts(@RequestParam("pagenumber") int pagenumber,@RequestParam("pagesize") int pagesize)
    {
        Page<Product> pg = productServices.getAllProducts(pagenumber, pagesize);
        //PageImpl<T> ts = new PageImpl<>(pg);
        return pg;


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

        return  productServices.replaceProduct(id, product);
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

package com.scaler.productservicejune24.services;

import com.scaler.productservicejune24.exceptions.ProductNotFoundException;
import com.scaler.productservicejune24.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProductServices {
    Product getSingleProduct(Long id) throws ProductNotFoundException;
    //List<Product> getAllProducts();

    Page<Product> getAllProducts(int pagenumber, int pagesize);

    //Page<Product> getAllProducts();

    void deleteProduct(Long id);
    Product updateProduct(Long id, Product product) throws ProductNotFoundException;
    Product replaceProduct(Long id, Product product) throws ProductNotFoundException;
    Product addnewproduct(Product product);

}

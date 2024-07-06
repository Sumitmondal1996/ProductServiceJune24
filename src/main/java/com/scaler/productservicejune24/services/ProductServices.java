package com.scaler.productservicejune24.services;

import com.scaler.productservicejune24.models.Product;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductServices {
    Product getSingleProduct(Long id);
    List<Product> getAllProducts();
    void deleteProduct(Long id);
    Product updateProduct(Long id, Product product);
    Product replaceProduct(Long id, Product product);

}

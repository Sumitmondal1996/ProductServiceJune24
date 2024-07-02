package com.scaler.productservicejune24.services;

import com.scaler.productservicejune24.models.Product;

import java.util.List;

public interface ProductServices {
    Product getSingleProduct(Long id);
    List<Product> getAllProducts();
}

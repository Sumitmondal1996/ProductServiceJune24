package com.scaler.productservicejune24.services;

import com.scaler.productservicejune24.dtos.FakeStoreProductDto;
import com.scaler.productservicejune24.models.Category;
import com.scaler.productservicejune24.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service // This annotations will ask Spring to create an object for FakeStoreProductServices
public class FakeStoreProductServices implements ProductServices{

    public RestTemplate restTemplate;
    public FakeStoreProductServices(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getSingleProduct(Long id) {
        // call fakestore service -- HTTP Call
        //RestTemplate restTemplate = new RestTemplate(); // This Class allows HTTP request from Springframework application
        FakeStoreProductDto fakeStoreProductDto=  restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);

        //Now convert FakeStoreProductDto into Product:
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());

        Category category = new Category();
        category.setDescription(fakeStoreProductDto.getDescription());

        product.setCategory(category);

        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}

package com.scaler.productservicejune24.services;

import com.scaler.productservicejune24.dtos.FakeStoreProductDto;
import com.scaler.productservicejune24.models.Category;
import com.scaler.productservicejune24.models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
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
//        RestTemplate restTemplate = new RestTemplate(); // This Class allows HTTP request from Springframework application
//        FakeStoreProductDto fakeStoreProductDto=  restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
//
//        //Now convert FakeStoreProductDto into Product:
//
//        return converttoproduct(fakeStoreProductDto);
        throw new NullPointerException();

    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtos =  restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        //convert fakeStoreProductDtos to List<Products>
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos)
        {
            products.add(converttoproduct(fakeStoreProductDto));


        }

        return products;
    }

    @Override
    public void deleteProduct(Long id) {

        restTemplate.delete("https://fakestoreapi.com/products/"+id);

    }

    @Override
    public Product updateProduct(Long id, Product product) {


        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {

        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDto.class, restTemplate.getMessageConverters());
        FakeStoreProductDto response = restTemplate.execute("https://fakestoreapi.com/products"+id, HttpMethod.PUT, requestCallback, responseExtractor);
        return converttoproduct(response);
    }

    public Product converttoproduct(FakeStoreProductDto fakeStoreProductDto)
    {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());

        Category category = new Category();
        category.setDescription(fakeStoreProductDto.getDescription());

        product.setCategory(category);

        return product;
    }
}

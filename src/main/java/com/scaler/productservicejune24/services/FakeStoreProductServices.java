package com.scaler.productservicejune24.services;

import com.scaler.productservicejune24.dtos.FakeStoreProductDto;
import com.scaler.productservicejune24.exceptions.ProductNotFoundException;
import com.scaler.productservicejune24.models.Category;
import com.scaler.productservicejune24.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Primary// This annotations will ask Spring to create an object for FakeStoreProductServices

public class FakeStoreProductServices implements ProductServices{

    public RestTemplate restTemplate;
    public RedisTemplate<String, Object> redisTemplate;
    public FakeStoreProductServices(RestTemplate restTemplate, RedisTemplate redisTemplate)
    {
        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;
    }
    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        Product product = (Product) redisTemplate.opsForHash().get("PRODUCTS", "PRODUCT_"+id); // Stores the data in Map, Key format
        if(product != null)
        {
            return product;
        }
        // call fakestore service -- HTTP Call
        RestTemplate restTemplate = new RestTemplate(); // This Class allows HTTP request from Springframework application
        FakeStoreProductDto fakeStoreProductDto=  restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
        if(fakeStoreProductDto==null)
        {
            throw  new ProductNotFoundException(id);
        }

        // if cache is not hit store the value in the cache;
        product = converttoproduct(fakeStoreProductDto);
        redisTemplate.opsForHash().put("PRODUCTS", "PRODUCT_"+id, product);

        //Now convert FakeStoreProductDto into Product:
        return product;
//        throw new ArithmeticException();

    }

    @Override
    public Page<Product> getAllProducts(int pagenumber, int pagesize) {
        FakeStoreProductDto[] fakeStoreProductDtos =  restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        //convert fakeStoreProductDtos to List<Products>
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos)
        {
            products.add(converttoproduct(fakeStoreProductDto));


        }

        //return products;

        return new PageImpl<>(products);
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

    @Override
    public Product addnewproduct(Product product) {
        return null;
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

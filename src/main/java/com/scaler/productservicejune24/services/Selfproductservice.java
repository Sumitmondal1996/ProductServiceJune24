package com.scaler.productservicejune24.services;

import com.scaler.productservicejune24.exceptions.ProductNotFoundException;
import com.scaler.productservicejune24.models.Category;
import com.scaler.productservicejune24.models.Product;
import com.scaler.productservicejune24.repositories.CategoryRepository;
import com.scaler.productservicejune24.repositories.ProductRepository;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
public class Selfproductservice implements  ProductServices{
    ProductRepository productRepository;
    CategoryRepository  categoryRepository;
    Selfproductservice(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty())
        {
            throw new ProductNotFoundException(id);
        }
        return product.get();
    }

    @Override
    public Page<Product> getAllProducts(int pagenumber, int pagesize) {
        //Sort sort = Sort.by("price").ascending().and(Sort.by("name").descending());
//        System.out.println("pagenumber: " + pagenumber);
//        System.out.println("pagesize: " + pagesize);
        Pageable pageable = PageRequest.of(pagenumber - 1, pagesize);
        return productRepository.findAll(pageable);
    }



    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);

    }

    @Override
    public Product updateProduct(Long id, Product product) throws ProductNotFoundException {
        Optional<Product> opt = productRepository.findById(id);
        if(opt.isEmpty())
        {
            throw new ProductNotFoundException(id);
        }
        Product productinDB = opt.get();
        if(product.getTitle()!=null)
        {
            productinDB.setTitle(product.getTitle());
        }
        if(product.getPrice()!=null)
        {
            productinDB.setPrice(product.getPrice());
        }
        return productRepository.save(productinDB);

    }

    @Override
    public Product replaceProduct(Long id, Product product) throws ProductNotFoundException {
        Category category = product.getCategory();
        if(category.getId()==0)
        {
            category = categoryRepository.save(category);
            product.setCategory(category);
        }

        Optional<Product> opt = productRepository.findByid(id);
        if(opt.isEmpty())
        {
            throw new ProductNotFoundException(id);
        }
        Product productinDB = opt.get();
        productinDB.setCategory(product.getCategory());
        productinDB.setTitle(product.getTitle());
        productinDB.setPrice(product.getPrice());
        return productRepository.save(productinDB);


    }

    @Override
    public Product addnewproduct(Product product) {
        Category category = product.getCategory();
        if(category.getId()==0)
        {
            category = categoryRepository.save(category);
            product.setCategory(category);

        }
        return productRepository.save(product);
    }
}

package com.scaler.productservicejune24.services;

import com.scaler.productservicejune24.exceptions.ProductNotFoundException;
import com.scaler.productservicejune24.models.Category;
import com.scaler.productservicejune24.models.Product;
import com.scaler.productservicejune24.repositories.CategoryRepository;
import com.scaler.productservicejune24.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfproductservice")
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
            throw new ProductNotFoundException("Product with "+ id + " not found");
        }
        return product.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
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
            throw new ProductNotFoundException("Product with "+ id + " not exist");
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
        return null;

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

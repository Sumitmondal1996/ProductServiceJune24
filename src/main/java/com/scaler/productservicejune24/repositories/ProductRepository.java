package com.scaler.productservicejune24.repositories;

import com.scaler.productservicejune24.models.Product;
import com.scaler.productservicejune24.projections.productwithtitleandid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    List<Product> findByPriceGreaterThan(Double price);
    List<Product> findByTitleContainingIgnoreCase(String title);
    Optional<Product> findByid(Long id);

    @Override
    List<Product> findAll();
    void deleteById(Long id);
    //Product save(Product product);

    // HQL:
    @Query("select title, id from Product where id = :x")
    productwithtitleandid randomsearchmethod(Long x);
}

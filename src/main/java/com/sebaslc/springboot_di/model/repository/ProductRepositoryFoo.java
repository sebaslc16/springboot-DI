package com.sebaslc.springboot_di.model.repository;

import com.sebaslc.springboot_di.model.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository("productFoo")
public class ProductRepositoryFoo implements ProductRepository{
    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Monitor ASUS 27", 600L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(id, "Monitor ASUS 27", 600L);
    }
}

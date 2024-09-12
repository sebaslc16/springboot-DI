package com.sebaslc.springboot_di.model.repository;

import com.sebaslc.springboot_di.model.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(Long id);

}

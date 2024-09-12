package com.sebaslc.springboot_di.service;

import com.sebaslc.springboot_di.model.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Product findById(Long id);
}

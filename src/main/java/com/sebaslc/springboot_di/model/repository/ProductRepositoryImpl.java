package com.sebaslc.springboot_di.model.repository;

import com.sebaslc.springboot_di.model.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
                new Product(1L, "Memory corsair 32", 300L),
                new Product(2L, "CPU Intel Core i9", 850L),
                new Product(3L, "Keyboard Razer Mini", 180L),
                new Product(4L, "Motherboard", 490L)
        );
    }

    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public Product findById(Long id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }
}

package com.sebaslc.springboot_di.service;

import com.sebaslc.springboot_di.model.entity.Product;
import com.sebaslc.springboot_di.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class ProductServiceImpl implements ProductService{

    private Environment environment;

    @Value("${config.price.tax}")
    private Double tax;

    //@Autowired
    //@Qualifier("productFoo")
    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository, Environment environment) {
        this.repository = repository;
        this.environment = environment;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            //Double priceTax = p.getPrice() * environment.getProperty("config.price.tax", Double.class);
            Double priceTax = p.getPrice() * tax;
            Product newProd = (Product) p.clone();
            newProd.setPrice(priceTax.longValue());
            return newProd;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }
}

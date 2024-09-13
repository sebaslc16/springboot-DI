package com.sebaslc.springboot_di;

import com.sebaslc.springboot_di.model.repository.ProductRepository;
import com.sebaslc.springboot_di.model.repository.ProductRepositoryJson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Bean("productJson")
    ProductRepository productRepositoryJson() {
        return new ProductRepositoryJson();
    }

}

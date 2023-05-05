package com.example.lesson1.service;

import com.example.lesson1.model.Product;
import com.example.lesson1.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class ProductSevice {

    private final ProductRepository productRepository;

    public ProductSevice(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Flux<Product> getAllProducts() {             // whole method takes 10 seconds to execute
        return productRepository
                .findAll()                              // 2 products
                .delayElements(Duration.ofSeconds(5));  // for any element add a sleep duration
    }
}

package com.example.lesson1.repositories;

import com.example.lesson1.model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepository extends ReactiveCrudRepository<Product, Integer> {
}

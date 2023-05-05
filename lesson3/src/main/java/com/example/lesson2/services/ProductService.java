package com.example.lesson2.services;

import com.example.lesson2.model.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

@Service
public class ProductService {

    public Flux<Product> getAll() {
        var p1 = new Product(); // from DB
        p1.setName("Beer");
        var p2 = new Product();
        p2.setName("Chocolate");
        var p3 = new Product();

        Flux<Product> products = Flux
                .fromStream(Stream.of(p1, p2, p3))
                .delayElements(Duration.ofSeconds(3)); // simulate something happens with each product

        return products;
    }

}

package com.example.lesson1.controllers;

import com.example.lesson1.model.Product;
import com.example.lesson1.service.ProductSevice;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ProductController {

    private final ProductSevice productSevice;

    public ProductController(ProductSevice productSevice) {
        this.productSevice = productSevice;
    }

    @GetMapping(value = "/product", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Product> getProducts() {
        return productSevice.getAllProducts();
    }
}

package com.example.lesson2_part2.service;

import com.example.lesson2_part2.model.Product;
import com.example.lesson2_part2.proxy.ProductProxy;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ProductService {

    private final ProductProxy productProxy;

    public ProductService(ProductProxy productProxy) {
        this.productProxy = productProxy;
    }

    public Flux<Product> getAll() {
        return productProxy.getAll();
    }

}

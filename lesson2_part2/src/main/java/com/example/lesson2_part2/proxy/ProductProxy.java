package com.example.lesson2_part2.proxy;

import com.example.lesson2_part2.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class ProductProxy {

    private final WebClient webClient;

    public ProductProxy(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<Product> getAll() {
        return webClient.get().uri("/products")
                .exchangeToFlux(res -> res.bodyToFlux(Product.class));
    }

}

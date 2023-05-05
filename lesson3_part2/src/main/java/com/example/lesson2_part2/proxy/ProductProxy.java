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
        var p = new Product();
        p.setName("Default");
        return webClient.get()
                .uri("/products")
                .exchangeToFlux(res -> res.bodyToFlux(Product.class))
//                .onErrorResume(e -> Flux.just(p));
//                .onErrorResume(WebClientRequestException.class, e -> Flux.just(p));
//                .onErrorResume(e -> e.getMessage() == null, e -> Flux.just(p));

//                .onErrorReturn(p);
//                .onErrorReturn(WebClientRequestException.class, p);
//                .onErrorReturn(e -> e.getMessage() == null, p);

//                .onErrorMap(e -> new ProductRetrieveException());

//                .doOnNext(n -> {
//                    if (n.getName() == null) throw new RuntimeException();
//                })
//                .onErrorContinue((e, o) -> System.out.println(e.getMessage()));
//                .onErrorContinue(RuntimeException.class, (e, o) -> System.out.println(e.getMessage()));
//                .onErrorContinue(e -> e.getMessage() == null, (e, o) -> System.out.println(e.getMessage()));

                .retry(3);
    }
}

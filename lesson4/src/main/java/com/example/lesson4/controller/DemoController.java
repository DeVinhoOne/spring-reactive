package com.example.lesson4.controller;

import com.example.lesson4.subscribers.DemoSubscriber;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public void demo() {
        // fixme |||| Flux and Mono represent PUBLISHERS
        Flux<Integer> f1 = Flux.just(1, 2, 3, 4, 5, 6);
//        var f2 = Flux.fromStream(Stream.of(1, 2, 3, 4, 5, 6, 7));
//        var f3 = Flux.fromIterable(Set.of(1, 2, 3, 4, 5, 6, 7));

//        var m1 = Mono.just(1);

        f1.doOnNext(c -> {
                    throw new RuntimeException("nooooooooo");
                })
                .subscribe(new DemoSubscriber());
    }
}

package com.example.lesson4.subscribers;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DemoSubscriber implements Subscriber<Integer> {

    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("Subscribed");
        this.subscription = subscription;
        subscription.request(1); //TODO ||| BACKPRESSURE
    }

    @Override
    public void onNext(Integer integer) {
        System.out.println("On next: " + integer);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("On error: " + t);
    }

    @Override
    public void onComplete() {
        System.out.println("On complete");
    }
}
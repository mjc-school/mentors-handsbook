package com.epam.light.talk.reactive.demo1;

import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

class MainTest {

    @Test
    public void createMono() {
        Mono.just(1)
//                .log()
                .doOnNext(System.out::println)
                .subscribe();
    }

    @Test
    public void createFlux() {
        Flux.just(1, 2, 3, 4)
                .log()
                .doOnNext(System.out::println)
                .subscribe();
    }

    @Test
    public void emptyMono() {
        Mono.empty()
//                .switchIfEmpty(Mono.just(1))
                .doOnNext(System.out::println)
                .doOnTerminate(() -> System.out.println("Finished"))
                .subscribe();
    }

    @Test
    public void error() {
        Mono.error(new RuntimeException())
                .doOnError(System.out::println)
                .subscribe();
    }

    @Test
    public void onErrorResume() {
        Mono.error(new RuntimeException())
                .onErrorResume(e -> Mono.just(1))
                .subscribe();
    }

    /**
     * Run multiple times
     */
    @Test
    public void retry() {
        Mono.just(1)
                .flatMap(i -> {
                    if (ThreadLocalRandom.current().nextBoolean()) {
                        return Mono.just(i);
                    }
                    System.out.println("Error occurred!");
                    return Mono.error(new RuntimeException());
                })
                .retry(10)
                .subscribe();
    }

    @Test
    public void monoDefer() {
//        Mono.empty()
        Mono.just(1)
//                .switchIfEmpty(heavyComputation())
                .switchIfEmpty(Mono.defer(this::heavyComputation))
                .doOnNext(System.out::println)
                .doOnTerminate(() -> System.out.println("Finished"))
                .subscribe();
    }

    private Mono<Integer> heavyComputation() {
        System.out.println("Doing heavy computations...");
        return Mono.just(1000).delayElement(Duration.ofMillis(1_000));
    }

    @Test
    public void fluxOperations() {
        Flux.just(1, 2, 3, 4)
                .filter(i -> i % 2 == 0)
                .map(i -> i * i)
                .skip(1)
                .doOnNext(System.out::println)
                .subscribe();
    }

    /**
     * Comment out subscribe, uncomment delay. Mono is still executed on another pool
     */
    @Test
    public void switchThreadPool() throws InterruptedException {
        Mono.just(1)
//                .delayElement(Duration.ofMillis(1_000))
                .doOnNext(i -> System.out.println(Thread.currentThread().getName() + " " + i))
                .subscribeOn(Schedulers.single())
                .subscribe();
        Thread.sleep(1_000);
    }

    @Test
    public void makeHttpRequestToGoogle() throws InterruptedException {
        WebClient webClient = WebClient.builder().build();
        webClient.get().uri("http://google.com")
                .retrieve()
                .bodyToMono(String.class)
                .doOnNext(s -> {
                    System.out.println(Thread.currentThread().getName() + " finished request. Content:");
                    System.out.println(s);
                })
                .subscribe();
        Thread.sleep(1_000);
    }

}
package com.epam.light.talk.reactive.demo1;

import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

class MainTest {

    @Test
    public void justTest() {
        Mono<Integer> mono = Mono.just(1);

        // 1
        System.out.println(mono);

//        //2
//        mono.subscribe();
//
//        //4 consumer for an item onNext
//        mono.subscribe((item) -> System.out.println("Received: " + item));
//
//        //4 consumer for an item onNext and error onError
//        mono.subscribe((item) -> System.out.println("Received: " + item), e -> System.out.println(e.getMessage()));
//
//        //4 consumer for an item onNext and error onError and runnable for onComplete
        mono.subscribe(
                (item) -> System.out.println("Received: " + item),
                e -> System.out.println(e.getMessage()),
                () -> System.out.println("Completed without error"));
    }

    @Test
    public void mapTest() {
        Mono.just(1)
                .map(i -> i / 2.)
                .subscribe(System.out::println);

//        Mono.just(1)
//                .map(i -> i / 0)
//                .subscribe(System.out::println);

    }

    @Test
    public void emptyTest() {
        getOrder(3)
                .subscribe(this::dataConsumer, this::errorConsumer, this::completeConsumer);
    }

    private Mono<String> getOrder(int orderId) {
        if (orderId == 1) {
            return Mono.just("order1");
        } else if (orderId == 2) {
            return Mono.empty();
        } else {
            return Mono.error(new RuntimeException("some error!"));
        }
    }

    @Test
    public void fromSupplierTest() {
        Mono<String> mono = Mono.just(emitSomeDataUsingLotsOfTime());

//        Mono.fromSupplier(this::emitSomeDataUsingLotsOfTime);
//        Mono.fromCallable(this::emitSomeDataUsingLotsOfTime);
//        Mono.fromRunnable(this::emitSomeDataUsingLotsOfTime);

    }

    private String emitSomeDataUsingLotsOfTime() {
        System.out.println("time consuming data computations...");
        return "data";
    }


    @Test
    public void fromFutureTest() {
        Mono<String> mono = Mono.fromFuture(CompletableFuture.supplyAsync(() -> {
            sleep(1);
            return "data";
        }));

        mono.subscribe(this::dataConsumer);

//        sleep(2);

//        System.out.println(mono.block());

    }


    @Test
    public void fluxTest() {
        List<Integer> list = List.of(1, 2, 3);
        Integer[] array = {1, 2, 3};
        Flux<Integer> flux = Flux.just(1, 2, 3);
        Flux<Integer> fromIterable = Flux.fromIterable(list);
        Flux<Integer> fromArray = Flux.fromArray(array);
        Flux<Integer> empty = Flux.empty();

        flux.subscribe(
                (item) -> System.out.println("Received: " + item),
                e -> System.out.println(e.getMessage()),
                () -> System.out.println("Completed without error"));
    }

    @Test
    public void fluxFilterMultipleSubscribersTest() {
        Flux<Integer> integers = Flux.just(1, 2, 3, 4);
//        Flux<Integer> even = integers.filter(i -> i % 2 == 0);

        integers.subscribe(i -> System.out.println("Sub1 : " + i));

        integers.subscribe(i -> System.out.println("Sub2 : " + i));
    }

    @Test
    public void streamMultipleSubscribersTest() {
        List<Integer> list = List.of(1, 2, 3, 4);
        Stream<Integer> stream = list.stream();
        Flux<Integer> flux = Flux.fromStream(stream);
//        Flux<Integer> flux = Flux.fromStream(list::stream);

        flux.subscribe(i -> System.out.println("Sub1 : " + i));

        flux.subscribe(i -> System.out.println("Sub2 : " + i));
    }

    @Test
    public void rangeFluxTest() {
        Flux.range(1, 10)
                .log()
                .map(i -> i * 2)
                .subscribe(this::dataConsumer);
    }

    @Test
    public void fluxVsListTest() {
        List<String> list = giveStringBlocking(5);
        Flux<String> flux = giveStringReactive(5);

        System.out.println(list);

//        flux.subscribe(this::dataConsumer);
    }

    private Flux<String> giveStringReactive(int count) {
        return Flux.range(1, count)
                .map(i -> getString());
    }

    private List<String> giveStringBlocking(int count) {
        List<String> list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(getString());
        }
        return list;
    }

    private String getString() {
        sleep(1);
        return String.valueOf(System.currentTimeMillis());
    }

    @Test
    public void monoToFluxTest() {
        Mono<Integer> mono = Mono.just(1);

        thirdPartyMethodAcceptFlux(Flux.from(mono));
    }


    private void thirdPartyMethodAcceptFlux(Flux<Integer> flux) {

    }

    @Test
    public void nextMethodTest() {
        Flux.range(1, 10)
                .filter(i -> i % 2 == 0)
                .next()
                .subscribe(this::dataConsumer);
    }

    @Test
    public void handleTest() {
        Flux.range(1, 10)
                .handle((i, sink) -> {
                    if (i > 0 && i < 7) {
                        sink.next(i * 2);
                    } else if (i > 8) {
                        sink.next(i * 2);
                    } else {
                        sink.error(new RuntimeException());
                    }
                })
                .subscribe(this::dataConsumer, this::errorConsumer);
    }

    @Test
    public void doHooksTest() {
        Flux.range(1, 3)
                .map(i -> i/0)
                .doFirst(() -> System.out.println("doFirst 1"))
                .doOnSubscribe(subscription -> System.out.println("doOnSub 1: " + subscription))
                .doOnNext(item -> System.out.println("doOnNext : " + item))
                .doOnError(e -> System.out.println("doOnError : " + e))
                .doOnComplete(() -> System.out.println("doOnComplete"))
                .doOnCancel(() -> System.out.println("doOnCancel"))
                .doOnRequest((count) -> System.out.println("doOnRequest : " + count))
                .doOnTerminate(() -> System.out.println("doOnTerminate"))
                .doFinally((signalType -> System.out.println("doFinally with signal : " + signalType)))
                .doOnSubscribe(subscription -> System.out.println("doOnSub 2: " + subscription))
                .doFirst(() -> System.out.println("doFirst 2"))
                .take(2)
                .doFinally((signalType -> System.out.println("doFinally with signal 2: " + signalType)))
                .subscribe(this::dataConsumer);
    }

    @Test
    public void errorsTest() {
        Flux.range(1, 10)
                .log()
                .map(i -> i / (i - 4))
//                .onErrorReturn(1)
//                .onErrorResume(e -> fallback())
//                .onErrorContinue((e, obj) -> {
//                })
                .subscribe(this::dataConsumer);
    }

    private Mono<Integer> fallback() {
        return Mono.fromSupplier(() -> {
            System.out.println("calculating..");
            return 23;
        });
//        System.out.println("calculating..");
//        return Mono.just(23);
    }

    @Test
    public void handleEmptyTest() {
        Flux.range(1, 10)
                .filter(i -> i > 0)
//                .defaultIfEmpty(2)
//                .switchIfEmpty(fallback())
                .subscribe(this::dataConsumer);
    }

    @Test
    public void flatMapTest() {
        int userId = 1;
        Mono.just(userId)
                .map(this::getOrderByUserId)
//                .flatMap(this::getOrderByUserId)
//                .flatMapMany(this::getOrdersByUserId)
                .subscribe(this::dataConsumer);
    }

    private Mono<String> getOrderByUserId(Integer userId) {
        return Mono.just("order3");
    }

    private Flux<String> getOrdersByUserId(Integer userId) {
        return Flux.just("order1", "order2", "order3");
    }

    @Test
    public void currentThreadTest() {
        Flux<Integer> flux = Flux.range(1, 10)
                .map(i -> {
                    System.out.println("map operator in thread " + Thread.currentThread().getName());
                    return i;
                });
        flux.subscribe();

//        Runnable runnable = () -> flux.subscribe(this::dataConsumer);
//
//        for (int i = 0; i < 2; i ++) {
//            new Thread(runnable).start();
//        }
//
//        sleep(1);
    }

    @Test
    public void subscribeOnTest() {
        Flux.range(1, 10)
                .map(i -> {
                    System.out.println("map 1 operator in thread " + Thread.currentThread().getName());
                    return i;
                })
                .subscribeOn(Schedulers.boundedElastic())
                .doFirst(() -> System.out.println("doFirst callback in thread " + Thread.currentThread().getName()))
                .subscribe();


        sleep(1);
    }

    @Test
    public void publishOnTest() {
        Flux.range(1, 10)
                .map(i -> {
                    System.out.println("map 1 operator in thread " + Thread.currentThread().getName());
                    return i;
                })
                .publishOn(Schedulers.boundedElastic())
                .map(i -> {
                    System.out.println("map 2 operator in thread " + Thread.currentThread().getName());
                    return i;
                })
                .subscribe();

        sleep(1);
    }

    @Test
    public void publishSubscribeOnTest() {
        Flux.range(1, 10)
                .map(i -> {
                    System.out.println("map 1 operator in thread " + Thread.currentThread().getName());
                    return i;
                })
                .publishOn(Schedulers.boundedElastic())
                .map(i -> {
                    System.out.println("map 2 operator in thread " + Thread.currentThread().getName());
                    return i;
                })
                .subscribeOn(Schedulers.parallel())
                .map(i -> {
                    System.out.println("map 3 operator in thread " + Thread.currentThread().getName());
                    return i;
                })
                .subscribe();

        sleep(1);
    }


    private void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void completeConsumer() {
        System.out.println("Completed without error");
    }

    private void errorConsumer(Throwable e) {
        System.out.println(e.getMessage());
    }


    private void dataConsumer(Object item) {
        System.out.println("Received: " + item);
    }
}
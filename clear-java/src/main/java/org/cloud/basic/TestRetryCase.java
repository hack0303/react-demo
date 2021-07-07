package org.cloud.basic;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestRetryCase {

    public static void main(String[] args){
        Flux.interval(Duration.ofMillis(100))
                .fromIterable(Stream.of(1,2,3).collect(Collectors.toList()))
                .filter(e->{if(e==3){
            int x=1/0; }return true;})
                .retry(10)
                .elapsed()
                .subscribe(System.out::println, System.err::println)
                .dispose();
        }
        }

package org.cloud.basic;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Case001 {

    public static void main(String[] args){
        Flux<String> flux=Flux.fromStream(Stream.of("a","b","c")).filter(e->!"b".equals(e)).doOnComplete(()->{
            System.out.println("complete!");
        });
        Mono<List<String>> lst=flux.collect(Collectors.toList());
        lst.block().forEach(e->{
            System.out.println(e);
        });
    }
}

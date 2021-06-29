package org.cloud.basic;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.cloud.util.LogUtil.printThreadInfo;

public class Case002 {

    public static void main(String[] args){
        printThreadInfo();
        System.out.println(Flux.fromArray(new String[]{"a","b","c"}).filter(e->e.equals("a")).log().blockFirst());
        Flux.fromArray(new String[]{"a","b","c"}).publishOn(Schedulers.single()).filter(e->e.equals("a")).log().blockFirst();
        Flux.fromArray(new String[]{"a","b","c"}).publishOn(Schedulers.parallel()).filter(e->e.equals("a")).log().blockFirst();
        Flux.fromArray(new String[]{"a","b","c"}).publishOn(Schedulers.elastic()).filter(e->e.equals("a")).log().blockFirst();
        Flux.fromArray(new String[]{"a","b","c"}).publishOn(Schedulers.immediate()).filter(e->e.equals("a")).log().blockFirst();
    }
}

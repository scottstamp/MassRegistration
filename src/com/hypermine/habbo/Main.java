package com.hypermine.habbo;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {
    private static final ExecutorService pool = Executors.newFixedThreadPool(60);

    public static void main(String[] args) throws Throwable {
        List<Registration> tasks = Proxies.getProxies()
                .stream()
                .map(Registration::new)
                .collect(Collectors.toList());

        pool.invokeAll(tasks, 10, TimeUnit.MINUTES);
        //pool.awaitTermination(10, TimeUnit.MINUTES);
        //pool.shutdownNow();
    }
}

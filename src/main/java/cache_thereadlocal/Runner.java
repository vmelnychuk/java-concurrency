package cache_thereadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    public static final int LENGTH = 10000;
    public static void main(String[] args) {
        long time;
        ExecutorService executorThreadLocal = Executors.newFixedThreadPool(LENGTH);
        ExecutorService executorCache = Executors.newFixedThreadPool(LENGTH);

        time = System.currentTimeMillis();
        for (int i = 0; i < LENGTH; i++) {
            executorCache.submit(new ThreadWithCache(i));
        }
        executorCache.shutdown();
        while (!executorCache.isTerminated()) {}
        System.out.println("Cache: " + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        for (int i = 0; i < LENGTH; i++) {
            executorThreadLocal.submit(new ThreadLocalVariable(i));
        }
        executorThreadLocal.shutdown();
        while (!executorThreadLocal.isTerminated()) {}
        System.out.println("ThreadLocal: " + (System.currentTimeMillis() - time));


        executorThreadLocal = Executors.newFixedThreadPool(LENGTH);
        executorCache = Executors.newFixedThreadPool(LENGTH);

        time = System.currentTimeMillis();
        for (int i = 0; i < LENGTH; i++) {
            executorCache.submit(new ThreadWithCache(i));
        }
        executorCache.shutdown();
        while (!executorCache.isTerminated()) {}
        System.out.println("Cache: " + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        for (int i = 0; i < LENGTH; i++) {
            executorThreadLocal.submit(new ThreadLocalVariable(i));
        }
        executorThreadLocal.shutdown();
        while (!executorThreadLocal.isTerminated()) {}
        System.out.println("ThreadLocal: " + (System.currentTimeMillis() - time));

        executorThreadLocal = Executors.newFixedThreadPool(LENGTH);
        executorCache = Executors.newFixedThreadPool(LENGTH);

        time = System.currentTimeMillis();
        for (int i = 0; i < LENGTH; i++) {
            executorCache.submit(new ThreadWithCache(i));
        }
        executorCache.shutdown();
        while (!executorCache.isTerminated()) {}
        System.out.println("Cache: " + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        for (int i = 0; i < LENGTH; i++) {
            executorThreadLocal.submit(new ThreadLocalVariable(i));
        }
        executorThreadLocal.shutdown();
        while (!executorThreadLocal.isTerminated()) {}
        System.out.println("ThreadLocal: " + (System.currentTimeMillis() - time));
    }
}

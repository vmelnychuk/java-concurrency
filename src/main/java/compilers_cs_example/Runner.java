package compilers_cs_example;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {
    public static final int LEN = 10000;
    public static final Random random = new Random();
    public static void main(String[] args) {
        final Simple2 simple = new Simple2();
        ExecutorService executorService = Executors.newFixedThreadPool(LEN);
        long time = System.currentTimeMillis();
        for (int i = 0; i < LEN; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    simple.to();
                }
            });
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    simple.fro();
                }
            });
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }
        System.out.println("Time: " + (System.currentTimeMillis() - time));

    }
}

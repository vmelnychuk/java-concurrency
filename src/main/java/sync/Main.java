package sync;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        Main app = new Main();
        app.doWork();
    }

    public void doWork() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    count.incrementAndGet();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    count.incrementAndGet();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count: " + count.get());
    }
}

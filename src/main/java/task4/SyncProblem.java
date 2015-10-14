package task4;

import model.Counter;
import model.IntegerCounter;
import model.LongCounter;

public class SyncProblem implements Runnable {
    public static final int TIMES = 10;
    private Counter counter;

    public SyncProblem(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i = 0; i < TIMES; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter.inc();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new LongCounter();
        SyncProblem thread1 = new SyncProblem(counter);
        SyncProblem thread2 = new SyncProblem(counter);
        new Thread(thread1).start();
        new Thread(thread2).start();
        new Thread(thread1).start();

        Thread.sleep(2000);
        System.out.println("Counter: " + counter.getCounterValue());

    }
}

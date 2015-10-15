package thread_start;

class CountDown extends Thread {
    public static final int START = 10;

    public CountDown() {
        super("CountDown");
    }
    @Override
    public void run() {
        int count = 0;
        while (count < START) {
            System.out.println(getName() + " " + count);
            count++;
            Thread.yield();
        }
    }
}

class CountUp implements Runnable {
    public static final int END = 10;
    @Override
    public void run() {
        int count = 0;
        do {
            System.out.println(Thread.currentThread().getName() + " " + count);
            count++;
            Thread.yield();
        } while (count < END);
    }
}
public class Main {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            private static final int LENGTH = 10;
            @Override
            public void run() {
                for(int i = 0; i < LENGTH; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                    Thread.yield();
                }
            }
        }, "Inner").start();
        CountDown countDown = new CountDown();
        countDown.start();

        new Thread(new CountUp(), "CountUp").start();
    }
}

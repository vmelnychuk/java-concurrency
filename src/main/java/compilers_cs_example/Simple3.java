package compilers_cs_example;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Simple3 {
    public static final Random random = new Random();
    private int a = 1;
    private int b = 2;
    private static ReentrantLock reentrantLock = new ReentrantLock();

    public void to() {
        try {
            reentrantLock.lock();
            a = random.nextInt(1000);
            b = a + 1;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void fro() {
        try {
            reentrantLock.lock();
            if (a + 1 != b) {
                System.out.println("a=" + a + ", b=" + b);
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}

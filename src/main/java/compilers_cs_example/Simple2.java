package compilers_cs_example;

import java.util.Random;

/**
 * There are only two possible scenarios:
 * 1) t1 do to() and t2 do fro()
 * 2) t2 do fro() and t1 do to()
 */
public class Simple2 {
    public static final Random random = new Random();
    private int a = 1;
    private int b = 2;

    public synchronized void to() {
        a = random.nextInt(1000);
        b = a+1;
    }

    public synchronized void fro() {
        if(a + 1 != b){
            System.out.println("a=" + a + ", b=" + b);
        }
//        System.out.println("a=" + a + ", b=" + b);
    }
}

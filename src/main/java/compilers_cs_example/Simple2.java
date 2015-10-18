package compilers_cs_example;

/**
 * There are only two possible scenarios:
 * 1) t1 do to() and t2 do fro()
 * 2) t2 do fro() and t1 do to()
 */
public class Simple2 {
    private int a = 1;
    private int b = 2;

    public synchronized void to() {
        a = 3;
        b = 4;
    }

    public synchronized void fro() {
        System.out.println("a=" + a + ", b=" + b);
    }
}

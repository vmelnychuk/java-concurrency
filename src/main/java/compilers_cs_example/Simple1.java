package compilers_cs_example;

/**
 * Do not fix problem of concurrent access and update.
 * possible scenario:
 * t1 execs to() a=3 and freezes, fro() don't check the lock and reads old value for b,
 * so write and read should be synchronized
 */
public class Simple1 {
    private int a = 1;
    private int b = 2;

    public synchronized void to() {
        a = 3;
        b = 4;
    }

    public void fro() {
        System.out.println("a=" + a + ", b=" + b);
    }
}

package task1;

public class ThreadTest extends Thread {
    private int i;
    public ThreadTest(int i) {
        this.i = i;
    }
    @Override
    public void run() {
        System.out.print(i + " ");
    }
}

package task1;

public class RunnableTest implements Runnable {
    private int i;

    public RunnableTest(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.print(i + " ");
    }
}

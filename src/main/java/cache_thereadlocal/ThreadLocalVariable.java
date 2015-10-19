package cache_thereadlocal;

public class ThreadLocalVariable extends ThreadBase implements Runnable {
    private ThreadLocal<Integer> threadLocalId = new ThreadLocal<Integer>();

    public ThreadLocalVariable(Integer id) {
        super(id);
    }

    @Override
    public void run() {
        this.threadLocalId.set(id);
        sleepTime();
        int b = threadLocalId.get() + SLEEP +1;
    }
}

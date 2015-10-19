package cache_thereadlocal;

public class ThreadBase {
    public static final int SLEEP = 100;
    protected int id;

    public ThreadBase(int id) {
        this.id = id;
    }

    public void sleepTime() {
        try {
            Thread.sleep(SLEEP);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

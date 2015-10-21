package cache_thereadlocal;

public class ThreadLocalVariable extends ThreadBase implements Runnable {
    public ThreadLocalVariable(Integer id) {
        super(id);
    }

    @Override
    public void run() {
        Cache.getInstance().setL(id);
        //sleepTime();
        int b = Cache.getInstance().getL() + SLEEP +1;
    }
}

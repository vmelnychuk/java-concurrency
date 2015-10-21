package cache_thereadlocal;

public class ThreadWithCache extends ThreadBase implements Runnable {
    private Cache cache = Cache.getInstance();
    public ThreadWithCache(Integer id) {
        super(id);
    }

    @Override
    public void run() {
        cache.set(id, id);
        //sleepTime();
        int b = cache.get(id) + SLEEP +1;
    }
}

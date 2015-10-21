package cache_thereadlocal;

import java.util.concurrent.ConcurrentHashMap;

public class Cache {
    private static final Cache cache = new Cache();
    private ConcurrentHashMap<Integer, Integer> cacheMap;
    private ThreadLocal<Integer> threadLocalId;

    private Cache(){
        cacheMap = new ConcurrentHashMap<Integer, Integer>();
        threadLocalId = new ThreadLocal<Integer>();
    };

    public static Cache getInstance() {
        return cache;
    }

    public Integer get(Integer key) {
        return cacheMap.remove(key);
    }

    public void set(Integer key, Integer value) {
        cacheMap.put(key, value);
    }

    public Integer getL() {
        return threadLocalId.get();
    }

    public void setL(Integer value) {
        threadLocalId.set(value);
    }
}

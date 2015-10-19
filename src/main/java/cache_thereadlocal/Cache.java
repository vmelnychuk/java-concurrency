package cache_thereadlocal;

import java.util.concurrent.ConcurrentHashMap;

public class Cache {
    private static final Cache cache = new Cache();
    private ConcurrentHashMap<Integer, Integer> cacheMap;

    private Cache(){
        cacheMap = new ConcurrentHashMap<Integer, Integer>();
    };

    public static Cache getInstance() {
        return cache;
    }

    public Integer get(Integer key) {
        return cacheMap.get(key);
    }

    public void set(Integer key, Integer value) {
        cacheMap.put(key, value);
    }
}

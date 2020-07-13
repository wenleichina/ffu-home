package com.funzuqiu.ffu.home.common.cache;

/**
 * Cache工具类
 */
public class CacheUtils {

    /**
     * 获取缓存
     * 
     * @param cacheName
     * @param key
     * @return
     */
    public static <T> T get(String cacheName, String key) {
        return getCache().get(cacheName, key);
    }

    /**
     * 获取缓存
     * 
     * @param cacheName
     * @param key
     * @param defaultValue
     * @return
     */
    public static <T> T get(String cacheName, String key, T defaultValue) {
        return getCache().get(cacheName, key, defaultValue);
    }

    /**
     * 写入缓存
     * 
     * @param cacheName
     * @param key
     * @param value
     */
    public static void put(String cacheName, String key, Object value) {
        getCache().put(cacheName, key, value);
    }

    /**
     * 写入缓存
     * 
     * @param cacheName
     * @param key
     * @param value
     * @param timeToLiveSeconds
     */
    public static void put(String cacheName, String key, Object value, int timeToLiveSeconds) {
        getCache().put(cacheName, key, value, timeToLiveSeconds);
    }

    /**
     * 从缓存中移除
     * 
     * @param cacheName
     * @param key
     */
    public static void remove(String cacheName, String key) {
        getCache().remove(cacheName, key);
    }

    /**
     * 从缓存中移除所有
     * 
     * @param cacheName
     */
    public static void removeAll(String cacheName) {
        getCache().removeAll(cacheName);
    }

    private static BaseCache getCache() {
        // return RedisUtils.getInstance();
        return EhcacheUtils.getInstance();
    }

}

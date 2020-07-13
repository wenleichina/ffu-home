package com.funzuqiu.ffu.home.common.cache;

/**
 * Cache工具类
 */
public interface BaseCache {

    /**
     * 获取缓存
     * 
     * @param cacheName
     * @param key
     * @return
     */
    <T> T get(String cacheName, String key);

    /**
     * 获取缓存
     * 
     * @param cacheName
     * @param key
     * @param defaultValue
     * @return
     */
    <T> T get(String cacheName, String key, T defaultValue);

    /**
     * 写入缓存
     * 
     * @param cacheName
     * @param key
     * @param value
     */
    void put(String cacheName, String key, Object value);

    /**
     * 写入缓存
     * 
     * @param cacheName
     * @param key
     * @param value
     * @param timeToLiveSeconds
     */
    void put(String cacheName, String key, Object value, int timeToLiveSeconds);

    /**
     * 从缓存中移除
     * 
     * @param cacheName
     * @param key
     */
    void remove(String cacheName, String key);

    /**
     * 从缓存中移除所有
     * 
     * @param cacheName
     */
    void removeAll(String cacheName);

}

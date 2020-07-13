package com.funzuqiu.ffu.home.common.cache;

import org.springframework.cache.ehcache.EhCacheCacheManager;

import com.funzuqiu.ffu.home.common.context.SpringContextHolder;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * Ehcache工具类
 */
public class EhcacheUtils implements BaseCache {

    private CacheManager cacheManager = SpringContextHolder.getBean(EhCacheCacheManager.class).getCacheManager();

    private static class EhcacheCacheUtilsFactory {
        private static final EhcacheUtils ehcacheCacheUtils = new EhcacheUtils();
    }

    public static EhcacheUtils getInstance() {
        return EhcacheCacheUtilsFactory.ehcacheCacheUtils;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T get(String cacheName, String key) {
        Element element = getCache(cacheName).get(key);
        return element != null ? ((T) element.getObjectValue()) : null;
    }

    @Override
    public <T> T get(String cacheName, String key, T defaultValue) {
        T value = get(cacheName, key);
        return value != null ? value : defaultValue;
    }

    @Override
    public void put(String cacheName, String key, Object value) {
        getCache(cacheName).put(new Element(key, value));
    }

    @Override
    public void put(String cacheName, String key, Object value, int timeToLiveSeconds) {
        getCache(cacheName).put(new Element(key, value, 0, timeToLiveSeconds));
    }

    @Override
    public void remove(String cacheName, String key) {
        getCache(cacheName).remove(key);
    }

    @Override
    public void removeAll(String cacheName) {
        getCache(cacheName).removeAll();
    }

    /**
     * 获得一个Cache，没有则创建一个。
     * 
     * @param cacheName
     * @return
     */
    private Cache getCache(String cacheName) {
        Cache cache = cacheManager.getCache(cacheName);
        if (cache == null) {
            cacheManager.addCache(cacheName);
            cache = cacheManager.getCache(cacheName);
            cache.getCacheConfiguration().setEternal(true);
        }
        return cache;
    }

}

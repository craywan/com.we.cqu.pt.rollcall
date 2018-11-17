package edu.uddp.util;



import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.net.URL;



public class EhcacheUtil {
    private static final String path = "/spring/encache.xml";

    private URL url;

    private CacheManager manager;

    private static EhcacheUtil ehCache;

    private EhcacheUtil(String path) {
        url = getClass().getResource(path);
        manager = CacheManager.create(url);
    }

    //得到缓存实例
    public static EhcacheUtil getInstance() {
        if (ehCache == null) {
            ehCache = new EhcacheUtil(path);
        }
        return ehCache;
    }

    //向缓存放入要存储的内容
    public void put(String cacheName, String key, Object value) {
        Cache cache = manager.getCache(cacheName);
        Element element = new Element(key, value);
        cache.put(element);
    }
    //缓存放入带有过期时间存储的内容
    public void put(String cacheName, String key, Object value,int timeToLiveSeconds) {
        Cache cache = manager.getCache(cacheName);
        Element element = new Element(key, value,timeToLiveSeconds);
        cache.put(element);
    }
    //判断KEY是否存在
//    public static boolean containskey(String key) {
//        return containskey(default_strategy, key);
//    }

    public static boolean containskey(String cacheStrategy, String key) {
        return getInstance().manager.getCache(cacheStrategy)
                .isKeyInCache(key);
    }



    //向缓存取出要存储的内容
    public Object get(String cacheName, String key) {
        Cache cache = manager.getCache(cacheName);
        Element element = cache.get(key);
        return element == null ? null : element.getObjectValue();
    }

    //得到参数名称对应的缓存
    public Cache get(String cacheName) {
        return manager.getCache(cacheName);
    }

    //移除参数名称对应的缓存
    public void remove(String cacheName, String key) {
        Cache cache = manager.getCache(cacheName);
        cache.remove(key);
    }
}


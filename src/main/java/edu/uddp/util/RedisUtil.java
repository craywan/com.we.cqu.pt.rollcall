package edu.uddp.util;

/**
 * @program: ssm
 * @description: redis工具类
 * @author: yangxinyu
 * @create: 2018-08-03
 **/

import com.sun.javafx.collections.MappingChange;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.*;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 * Redis工具类
 */
@Component
public class RedisUtil {
    private RedisTemplate<Serializable, Object> redisTemplate;


    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     *
     * @param pattern
     */
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0) {
            redisTemplate.delete(keys);
        }
        closeConn(redisTemplate);
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
        closeConn(redisTemplate);
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate
                .opsForValue();
        result = operations.get(key);
        closeConn(redisTemplate);
        return result;
    }

    /**
     * 获取reedis中的map集合中的value
     * @param key
     * @param mapKey
     * @return
     */
    public Object getHashKey(final String key,final String mapKey) {
        Object result = null;
        HashOperations<Serializable, Object,Object> operations = redisTemplate
                .opsForHash();
        result = operations.get(key,mapKey);
        System.out.println(result);
        closeConn(redisTemplate);
        return result;
    }

    public Map<Object,Object> getHashKeys(final String key) {
       Map<Object,Object> result = new HashMap<>();
        HashOperations<Serializable, Object,Object> operations = redisTemplate
                .opsForHash();
        //获取Map集合
        Cursor<Map.Entry<Object, Object>> cursors =operations.scan(key, ScanOptions.NONE);
        while(cursors.hasNext()) {
            Map.Entry<Object, Object> entry = cursors.next();
           result.put(entry.getKey(),entry.getValue());
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        closeConn(redisTemplate);
        return result;
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate
                    .opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConn(redisTemplate);
        }
        return result;
    }
    public boolean setHash(final String key, Map<Object,Object> value) {
        boolean result = false;
        try {
            HashOperations<Serializable,Object,Object> operations = redisTemplate
                    .opsForHash();
            operations.putAll(key,value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeConn(redisTemplate);
        }
        return result;
    }

    /**
     * 更新数据
     * @param key
     * @param mapKey
     * @return
     */
    public boolean updataHash(final String key, final Object mapKey,final Object mapValue) {
        boolean result = false;
        try {
            HashOperations<Serializable,Object,Object> operations = redisTemplate
                    .opsForHash();
            operations.put(key,mapKey,mapValue);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeConn(redisTemplate);
        }
        return result;
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate
                    .opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeConn(redisTemplate);
        }
        return result;
    }

    /**
     * 创建链接
     * @param redisTemplate
     */
    public void setRedisTemplate(RedisTemplate<Serializable, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 回收redis连接
     * @param redisTemplate
     */
    public static void closeConn(RedisTemplate<Serializable, Object> redisTemplate){
//        redisTemplate.exec();
        RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
    }

}
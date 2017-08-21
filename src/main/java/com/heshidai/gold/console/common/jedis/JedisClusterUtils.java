package com.heshidai.gold.console.common.jedis;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.JedisCluster;

import com.heshidai.gold.console.common.util.ObjectUtils;
import com.heshidai.gold.console.common.util.StringUtils;

/**
 * 功能：JedisClusterUtils
 *
 * @version 2017年1月4日下午3:44:30
 * @author baocheng.ren
 */
public class JedisClusterUtils {
    @Autowired
    private JedisCluster jedisCluster;
    
    /**
     * 获取缓存
     * 
     * @param key 键
     * @return 值
     */
    public static Object getObject(String key) {
        return null;
    }
    
    /**
     * 获取byte[]类型Key
     * 
     * @param object object
     * @return byte[]
     */
    public static byte[] getBytesKey(Object object) {
        if (object instanceof String) {
            return StringUtils.getBytes((String) object);
        }
        else {
            return ObjectUtils.serialize(object);
        }
    }
    
    /**
     * 功能：Object转换byte[]类型
     *
     * @version 2017年1月4日下午3:44:49
     * @author baocheng.ren
     * @param object object
     * @return byte[]
     */
    public static byte[] toBytes(Object object) {
        return ObjectUtils.serialize(object);
    }
    
    /**
     * byte[]型转换Object
     * 
     * @param bytes bytes
     * @return Object
     */
    public static Object toObject(byte[] bytes) {
        return ObjectUtils.unserialize(bytes);
    }
    
}

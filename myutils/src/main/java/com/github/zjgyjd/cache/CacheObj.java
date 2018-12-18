package com.github.zjgyjd.cache;

/**
 * 缓存对象
 * Author: secondriver
 * Created: 2018/10/16
 *
 * @param <K> Key类型
 * @param <V> Value类型
 */
public class CacheObj<K, V> {
    
    private final K key;
    private final V obj;
    
    /**
     * 上次访问时间
     */
    private long lastAccess;
    /**
     * 访问次数
     */
    private long accessCount;
    /**
     * 对象存活时长，0表示永久存活
     */
    private long ttl;
    
    public CacheObj(K key, V obj, long ttl) {
        this.key = key;
        this.obj = obj;
        this.ttl = ttl;
        this.lastAccess = System.currentTimeMillis();
    }
    
    /**
     * 判断是否过期
     *
     * @return 是否过期
     */
    public boolean isExpired() {
        return (this.ttl > 0) && (this.lastAccess + this.ttl < System.currentTimeMillis());
    }
    
    /**
     * 获取值
     *
     * @param isUpdateLastAccess 是否更新最后访问时间
     * @return 获得对象
     */
    public V get(boolean isUpdateLastAccess) {
        if (isUpdateLastAccess) {
            lastAccess = System.currentTimeMillis();
        }
        accessCount++;
        return obj;
    }
    
    /**
     * 获取键
     *
     * @return 键
     */
    public K getKey() {
        return this.key;
    }
    
    /**
     * 获取值
     *
     * @return 值
     */
    public V getValue() {
        return this.obj;
    }
    
    @Override
    public String toString() {
        return "CacheObj [key=" + key + ", obj=" + obj + ", lastAccess=" + lastAccess + ", accessCount=" + accessCount + ", ttl=" + ttl + "]";
    }
}

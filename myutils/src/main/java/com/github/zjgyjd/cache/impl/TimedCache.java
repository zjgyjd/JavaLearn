package com.github.zjgyjd.cache.impl;


import com.github.zjgyjd.cache.CacheObj;
import com.github.zjgyjd.util.StringUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 定时缓存，此缓存没有容量限制，对象只有在过期后才会被移除
 * <p>
 * Author: secondriver
 * Created: 2018/10/16
 */
public class TimedCache<K, V> extends AbstractCache<K, V> {
    
    /**
     * 正在执行的定时任务
     */
    
    private ScheduledFuture<?> pruneJobFuture;
    
    private ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(16, new ThreadFactory() {
        
        private AtomicInteger cacheTaskNumber = new AtomicInteger(1);
        
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(
                    r, StringUtil.format("Pure-Timer-{}", cacheTaskNumber.getAndIncrement())
            );
        }
    });
    
    
    /**
     * 构造
     *
     * @param timeout 超时（过期）时长，单位毫秒
     */
    public TimedCache(long timeout) {
        this(timeout, new HashMap<>());
    }
    
    /**
     * 构造
     *
     * @param timeout 过期时长
     * @param map     存储缓存对象的map
     */
    public TimedCache(long timeout, Map<K, CacheObj<K, V>> map) {
        this.capacity = 0;
        this.timeout = timeout;
        this.cacheMap = map;
    }
    
    
    /**
     * 清理过期对象
     *
     * @return 清理数
     */
    @Override
    protected int pruneCache() {
        int count = 0;
        Iterator<CacheObj<K, V>> values = cacheMap.values().iterator();
        CacheObj<K, V> co;
        while (values.hasNext()) {
            co = values.next();
            if (co.isExpired()) {
                values.remove();
                count++;
            }
        }
        return count;
    }
    
    
    /**
     * 定时清理
     *
     * @param delay 间隔时长，单位毫秒
     */
    public void schedulePrune(long delay) {
        this.pruneJobFuture = executor.schedule(new Runnable() {
            @Override
            public void run() {
                prune();
            }
        }, delay, TimeUnit.MILLISECONDS);
    }
    
    /**
     * 取消定时清理
     */
    public void cancelPruneSchedule() {
        if (null != pruneJobFuture) {
            pruneJobFuture.cancel(true);
        }
    }
}

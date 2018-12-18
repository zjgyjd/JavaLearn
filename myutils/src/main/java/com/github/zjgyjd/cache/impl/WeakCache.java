package com.github.zjgyjd.cache.impl;

import com.github.zjgyjd.cache.CacheObj;

import java.util.WeakHashMap;

/**
 * 弱引用缓存:
 * 对于一个给定的键，其映射的存在并不阻止垃圾回收器对该键的丢弃，这就使该键成为可终止的，被终止，然后被回收。<br>
 * 丢弃某个键时，其条目从映射中有效地移除。
 * Author: secondriver
 * Created: 2018/10/16
 */
public class WeakCache<K, V> extends TimedCache<K, V> {
    
    public WeakCache(long timeout) {
        super(timeout, new WeakHashMap<K, CacheObj<K, V>>());
    }

}

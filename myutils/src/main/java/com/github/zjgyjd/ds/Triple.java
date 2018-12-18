package com.github.zjgyjd.ds;

import java.io.Serializable;

/**
 * 三元组对象
 * Author: secondriver
 * Created: 2018/10/16
 */
public final class Triple<L, M, R> implements Serializable {
    
    private final L left;
    
    private final M middle;
    
    private final R right;
    
    private Triple(L left, M middle, R right) {
        this.left = left;
        this.middle = middle;
        this.right = right;
    }
    
    public static <L, M, R> Triple<L, M, R> of(L left, M middle, R right) {
        //TODO
        return null;
    }
    
    public L getLeft() {
        //TODO
        return null;
    }
    
    public M getMiddle() {
        //TODO
        return null;
    }
    
    public R getRight() {
        //TODO
        return null;
    }
    
    
    @Override
    public boolean equals(final Object obj) {
        //TODO
        return false;
    }
    
    @Override
    public int hashCode() {
        //TODO
        return -1;
    
    }
    
    @Override
    public String toString() {
        //TODO
        return null;
    }
}

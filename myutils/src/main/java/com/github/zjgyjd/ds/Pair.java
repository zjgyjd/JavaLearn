package com.github.zjgyjd.ds;


import java.io.Serializable;

/**
 * 键值对对象，只能在构造时传入键值
 * <p>
 * Author: secondriver
 * Created: 2018/10/16
 */
public final class Pair<L, R> implements Serializable {
    
    private final L left;
    
    private final R right;
    
    private Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }
    
    public static <L, R> Pair<L, R> of(final L left, final R right) {
        //TODO
        return null;
    }
    
    
    public R getRight() {
        //TODO
        return null;
    }
    
    public L getLeft() {
        //TODO
        return null;
    }
    
    @Override
    public String toString() {
        //TODO
        return null;
    }
    
    
    @Override
    public int hashCode() {
        //TODO
        return -1;
    }
    
    
    @Override
    public boolean equals(final Object obj) {
        //TODO
        return false;
    }
}

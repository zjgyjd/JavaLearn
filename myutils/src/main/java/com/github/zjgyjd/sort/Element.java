package com.github.zjgyjd.sort;

/**
 * Author: secondriver
 * Created: 2018/9/10
 */
public class Element<T> implements Comparable {
    
    private int key;
    
    private T data;
    
    public Element(int key, T data) {
        this.key = key;
        this.data = data;
    }
    
    public int getKey() {
        return key;
    }
    
    public void setKey(int key) {
        this.key = key;
    }
    
    public T getData() {
        return data;
    }
    
    public void setData(T data) {
        this.data = data;
    }
    
    @Override
    public int compareTo(Object o) {
        if (o == null) {
            throw new IllegalArgumentException("Object o must be not null");
            
        }
        if (!(o instanceof Element)) {
            throw new IllegalArgumentException("Object o must be DataElement instance");
        }
        Element that = (Element) o;
        return Integer.compare(this.key, that.key);
    }
    
    @Override
    public String toString() {
        return String.valueOf(key + data.toString());
    }
}

package com.github.zjgyjd.DS.genericType;

import java.util.*;

/**
 * 顺序表
 *
 * @param <E>
 */
public class SeqList<E> implements List<E> {
    private class SeqListIterator implements Iterator<E> {
        int index;

        SeqListIterator() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            return array[index++];
        }

        @Override
        public void remove() {
            //表示的是和迭代器对象绑定的顺序表的对象
            SeqList.this.remove(--index);
        }
    }

    //属性
    private E[] array; //存储真正数据的位置
    private int size;    //顺序表中实际存储的个数
    private final static int DEFAULT_SIZE = 10;

    public SeqList() {
        this.array = (E[]) new Object[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {

        return new SeqListIterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return (T[])Arrays.copyOf(array,size);//从头拷贝,拷贝多长
    }

    @Override
    public boolean add(E e) {
        array[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, size));
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        array = (E[]) new Object[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public E get(int index) {
        return array[index];
    }

    @Override
    public E set(int index, E element) {
        E oldValue = array[index];
       array[index] = element;
       return oldValue;
    }

    @Override
    public void add(int index, E element) {
        checkCapacity();
        for (int i = size++; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
    }

    @Override
    public E remove(int index) {
        E oldValue = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null;
        return oldValue;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if(array[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size -1; i >= 0 ; i--) {
            if(array[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        SeqList<E> subList = new SeqList<>();
        subList.array = Arrays.copyOfRange(array,fromIndex,toIndex);
        subList.size = toIndex - fromIndex;
        return subList;
    }

    /**
     * 考虑扩容
     */
    private void checkCapacity(){
        if(size < array.length){
            return;
        }else {
            int oldCapacity = array.length;
            int newCapacity = 2 * oldCapacity;
            Object[] newArray = new Object[newCapacity];
            for (int i = 0; i < oldCapacity; i++) {
                newArray[i] = array[i];
            }
            array = (E[])newArray;
        }
    }
}

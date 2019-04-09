package com.github.zjgyjd.DS.List;

public class MyArrayList implements IArrayList {
    private int[] array;
    private int size;

    MyArrayList(int camp) {
        this.array = new int[camp];
        this.size = 0;
    }

    //O(n)
    @Override
    public void pushFront(int item) {
        //将顺序表中已有的数据后移一个
        //for (int i = this.size; i >= 1; i--) {
        //   this.array[i] = this.array[i - 1];
        //}

        this.ensureCapacity();
        //按数据移动下标
        for (int i = size - 1; i >= 0; i--) {
            this.array[i + 1] = this.array[i];
        }

        this.array[0] = item;
        this.size++;
    }

    //O(1)
    @Override
    public void pushBack(int item) {
        this.ensureCapacity();
        this.array[this.size] = item;
        this.size++;
    }

    //O(n)
    @Override
    public void add(int item, int index) {
        if (index < 0 || index > this.size) {
            throw new Error();
        }
        this.ensureCapacity();
        for (int i = this.size; i > index; i--) {
            this.array[i] = this.array[i - 1];
        }

        this.array[index] = item;
        this.size++;
    }

    //O(n)
    @Override
    public void popFront() {
        if (this.size == 0) {
            throw new Error();
        }
        for (int i = 0; i < size - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.array[--this.size] = 0;
    }

    //O(1)
    @Override
    public void popBack() {
        if (this.size == 0) {
            throw new Error();
        }
        this.array[--this.size] = 0;
    }

   // O(n)
    @Override
    public void remove(int index) {
        if (this.size == 0) {
            throw new Error();
        }
        if(index<0||index>=this.size){
            throw new Error();
        }
        for (int i = index; i < size - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.array[--this.size] = 0;
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();
        temp.append("[").append(" ");
        for (int i = 0; i < size; i++) {
            temp.append(array[i]).append(" ");
        }
        temp.append("]");
        return temp.toString();
    }

    //O(n)
    /**
     * 保证数组容量
     */
    private  void ensureCapacity(){
        if(this.size <this.array.length){
            return;
        }
        //1.找原来的两倍大
        int capacity = this.array.length *2;
        int[] newArray = new int[capacity];
        for (int i = 0; i < this.size; i++) {
            newArray[i]=this.array[i];
        }
        this.array = newArray;
    }

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList(10);
        myArrayList.pushBack(1);
        myArrayList.pushBack(2);
        myArrayList.pushBack(3);
        myArrayList.add(5, 2);
        myArrayList.pushFront(8);
        myArrayList.popFront();
        myArrayList.remove(1);
        System.out.println(myArrayList);
    }
}

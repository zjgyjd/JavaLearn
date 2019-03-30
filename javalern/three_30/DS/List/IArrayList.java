package com.github.zjgyjd.DS.List;

public interface IArrayList {

    //增/删
    /**
     * 把item插入到线性表前面
     * @parm item 要插入的数据
     */
    void pushFront(int item);

    /**
     * 从线性表最后插入
     * @param item
     */
    void pushBack(int item);

    /**
     * 插入到任何位置
     * @param item
     * @param index
     */
    void add(int item,int index);

    /**
     * 将线性表第一个删除
     */
    void popFront();

    /**
     * 将线性表最后删除
     */
    void popBack();

    /**
     * 删除任意位置
     * @param index
     */
    void remove(int index);

    //改/查
}

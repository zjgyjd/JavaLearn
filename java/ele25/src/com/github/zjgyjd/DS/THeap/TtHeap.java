package com.github.zjgyjd.DS.THeap;

import java.lang.reflect.Array;
import java.util.Arrays;


public class TtHeap {
    private int[] array;
    private int size;

    public TtHeap(int[] array) {
        this.array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            this.array[i] = array[i];
        }
        this.size = array.length;

        createHeap(array, this.size);
    }

    /**
     * 查看最大元素
     *
     * @return
     */
    int top() {
        return array[0];
    }

    int pop() {
        int v = array[0];
        array[0] = array[this.size - 1];
        this.size--;

        heapify(array, 0, size);
        return v;
    }

    void push(int v) {
        array[size++] = v;

        adjustUp(array, size, size - 1);
    }

    int getSize(){
        return size;
    }
    /**
     * 向上调整
     *
     * @param array
     * @param size
     * @param index
     */
    private void adjustUp(int[] array, int size, int index) {
        if (index == 0) {
            return;
        }
        int p = (index - 1) / 2;
        if (array[index] <= array[p]) {
            return;
        }

        int t = array[p];
        array[p] = array[index];
        array[index] = t;
        heapify(array,index,size);
        adjustUp(array,size,p);
    }

    /**
     * 向下调整(堆化)
     * 必须满足可以向下调整前提:只有一个位置不满住
     * 时间复杂度为二叉树高度即:log n
     *
     * @param tree  看成完全二叉树的数组
     * @param index 要调整的下标
     */
    public static void heapify(int[] tree, int index, int size) {
        /**
         * 判断index 位置是不是叶子节点
         * 只要判断有没有左孩子
         * 转化为数组下标越界的问题去判断
         */
        int max = 2 * index + 1;
        if (max >= size) {
            return;
        }

        /**
         * 不是叶子节点,一定有左,但不一定有右
         * 大堆就找到最大的孩子
         *  1.没有右孩子
         *  2.左大
         *  3.右大
         */


        if (max + 1 < size && tree[max + 1] > tree[max]) {
            max++;
        }

        /**
         * 3.和根的值进行比较,如果根大则不调,否则交换,并且继续以max做下标,进行向下调整
         */
        if (tree[index] >= tree[max]) {
            return;
        }
        int t = tree[index];
        tree[index] = tree[max];
        tree[max] = t;

        heapify(tree, max, size);
    }

    /**
     * 将无序数组创建成一个大堆
     * 时间复杂:O(n) (仔细算)
     * 大概为O(n * log n)
     *
     * @param array
     */
    public static void createHeap(int[] array, int size) {
        //从最后一个叶子节点的双亲下标开始,一路向下调整到根
        for (int i = (size - 2) / 2; i >= 0; i--) {
            heapify(array, i, size);
        }
    }
}


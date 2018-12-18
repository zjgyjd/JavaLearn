package com.github.zjgyjd.sort.impl;

import com.github.zjgyjd.sort.Element;
import com.github.zjgyjd.sort.Sorter;

/**
 * 冒泡排序  样例实现
 * <p>
 * Author: secondriver
 * Created: 2018/10/13
 */
public class BubbleSorter implements Sorter {
    
    @Override
    public void sort(Element[] elements) {
        for (int i = 0; i < elements.length - 1; i++) {
            boolean flag = false;
            //如果j索引处的元素大于j+1索引处的元素，进行交换
            for (int j = 0; j < elements.length - 1 - i; j++) {
                if (elements[j].compareTo(elements[j + 1]) > 0) {
                    Element temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                    flag = true;
                }
            }
            //如果某趟没有发生交换，则表明已处于有序状态
            if (!flag) {
                break;
            }
        }
    }
}

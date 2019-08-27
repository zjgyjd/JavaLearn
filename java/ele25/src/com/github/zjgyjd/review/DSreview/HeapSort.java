package com.github.zjgyjd.review.DSreview;

/**
 * 已知parent:则孩子为left = 2 * parent + 1;
 * right = 2 * parent + 2;
 * parent = (child - 1)/2
 * 堆的基本应用: 找最值
 * 操作: 向下调整(满足前提,除了要调整的位置之外,其余位置必须满足堆的性质
 */
public class HeapSort {
    public void down(int[] heap, int index, int size) {
        int target = heap[index];
        int left = index * 2 + 1;
        if (left >= size) {
            return;
        }
        int right = left + 1;
        int max = heap[left];
        if (right < size) {
            if (heap[left] < heap[right]) {
                max = heap[right];
            }
        }
        if (target < max) {
            swap(index, left, heap);
            down(heap, left, size);
        }
    }

    private void swap(int index, int left, int[] heap) {
        int temp = heap[index];
        heap[index] = heap[left];
        heap[left] = temp;
    }

    public void createHeap(int[] heap, int size) {
        for (int i = (size - 2) / 2; i >= 0; i--) {
            down(heap, i, size);
        }
    }

    public void sortHeap(int[] heap){
        for (int i = 0 ; i < heap.length ; i++){
            createHeap(heap, heap.length -  i);
            swap(0, heap.length - i- 1, heap);
        }
    }
}

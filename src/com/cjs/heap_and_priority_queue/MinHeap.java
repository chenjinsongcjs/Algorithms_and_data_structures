package com.cjs.heap_and_priority_queue;

import com.cjs.arrays.Array;

public class MinHeap<E extends Comparable<E>> {
    private Array<E> array;

    public MinHeap(int capacity) {
        array = new Array<>(capacity);
    }

    public MinHeap() {
        array = new Array<>();
    }

    public MinHeap(E[] arr) {
        array = new Array<>(arr);
        for (int i = parent(array.getSize() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public void add(E e) {
        array.addLast(e);
        siftUp(array.getSize() - 1);
    }

    public E findMin() {
        if (array.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return array.get(0);
    }

    public E extractMin() {
        E min = findMin();
        array.swap(0, array.getSize() - 1);
        array.removeLast();
        siftDown(0);
        return min;
    }

    public E replace(E e) {
        E retVal = findMin();
        array.set(0, e);
        siftDown(0);
        return retVal;
    }

    //辅助函数
    private int parent(int k) {
        if (k == 0)
            throw new IllegalArgumentException("index-0 没有父节点");
        return (k - 1) / 2;
    }

    private int leftChild(int k) {
        return 2 * k + 1;
    }

    private int rightChild(int k) {
        return 2 * k + 2;
    }

    private void siftUp(int k) {
        while (k > 0 && array.get(parent(k)).compareTo(array.get(k)) > 0) {
            array.swap(k, parent(k));
            k = parent(k);
        }
    }

    private void siftDown(int k) {
        while (leftChild(k) < array.getSize()) {
            int j = leftChild(k);
            if (j + 1 < array.getSize() && array.get(j + 1).compareTo(array.get(j)) < 0)
                j++;
            if (array.get(k).compareTo(array.get(j)) <= 0)
                break;
            array.swap(k, j);
            k = j;
        }
    }
}

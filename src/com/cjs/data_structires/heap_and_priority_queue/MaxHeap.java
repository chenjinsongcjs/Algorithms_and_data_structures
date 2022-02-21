package com.cjs.data_structires.heap_and_priority_queue;

import com.cjs.data_structires.arrays.Array;

/**
 * 大顶堆：采用数组实现
 * 堆是一颗完全二叉树
 * 父节点的值不小于孩子节点的值
 *
 * @param <E>
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> array;

    public MaxHeap() {
        array = new Array<>();
    }

    public MaxHeap(int capacity) {
        array = new Array<>(capacity);
    }

    //heapify
    public MaxHeap(E[] arr) {
        array = new Array<>(arr);
        //从最后一个非叶子节点开始往前进行下沉操作
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public int getSize() {
        return array.getSize();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    //从数组的0索引开始计算
    //返回某一个节点的父节点索引
    private int parent(int k) {
        return (k - 1) / 2;
    }

    //返回某个节点的左孩子索引
    private int leftChild(int k) {
        return 2 * k + 1;
    }

    //返回某个节点的右孩子索引
    private int rightChild(int k) {
        return 2 * k + 2;
    }

    //添加元素：在数组末尾添加元素，执行上浮操作
    public void add(E e) {
        array.addLast(e);
        siftUp(array.getSize() - 1);
    }

    //获取最大值
    public E findMax() {
        if (array.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return array.get(0);
    }

    //移除最大值
    public E extractMax() {
        E retVal = findMax();
        array.swap(0, array.getSize() - 1);
        array.removeLast();
        siftDown(0);
        return retVal;
    }

    //替换堆中的最大元素
    public E replace(E e) {
        E retVal = findMax();
        array.set(0, e);
        siftDown(0);
        return retVal;
    }

    //上浮操作
    private void siftUp(int k) {
        //当前节点不是根节点，且当前节点小于父节点，交换
        while (k > 0 && array.get(parent(k)).compareTo(array.get(k)) < 0) {
            array.swap(k, parent(k));
            k = parent(k);
        }
    }

    //下沉操作:与左右孩子中的最大值交换
    private void siftDown(int k) {
        //当前节点为非叶子节点，才进行下沉操作
        while (leftChild(k) < array.getSize()) {
            int j = leftChild(k);
            //有右孩子，和右孩子比较取最大值
            if (j + 1 < array.getSize() && array.get(j).compareTo(array.get(j + 1)) < 0)
                j++;
            //当前节点比左右孩子都大，直接返回
            if (array.get(k).compareTo(array.get(j)) >= 0)
                break;
            array.swap(k, j);
            k = j;
        }
    }
}

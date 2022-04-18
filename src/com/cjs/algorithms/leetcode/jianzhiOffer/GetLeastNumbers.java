package com.cjs.algorithms.leetcode.jianzhiOffer;

import java.util.ArrayList;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，
 * 则最小的4个数字是1、2、3、4。
 * <p>
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        MinHeap minHeap = new MinHeap(arr);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.getMin();
        }
        return result;
    }
}
//自定小根堆实现
class MinHeap {
    private final int[] data;
    private int size;

    public MinHeap(int[] arr) {
        data = arr;
        size = arr.length;
        //从最后一个叶子节点开始siftUp
        for (int i = parent(size - 1); i > 0; i--) {
            siftDown(i);
        }
    }

    private int leftChild(int k) {
        return 2 * k + 1;
    }

    private int rightChild(int k) {
        return 2 * k + 2;
    }

    private int parent(int k) {
        return (k - 1) / 2;
    }

    //上浮
    private void siftUp(int k) {
        while (k > 0 && data[k] < data[parent(k)]) {
            int tmp = data[k];
            data[k] = data[parent(k)];
            data[parent(k)] = tmp;
            k = parent(k);
        }
    }

    //下沉操作
    private void siftDown(int k) {
        //有左孩子，叶子节点不同下沉
        while (leftChild(k) < data.length) {
            int j = leftChild(k);
            if (j + 1 < size && data[j + 1] < data[j])
                j++;
            if (data[k] <= data[j])
                break;//比最小的小
            //交换，
            int tmp = data[k];
            data[k] = data[j];
            data[j] = tmp;
            k = j;
        }
    }

    public int getMin() {
        if (size > 0) {
            int min = data[0];
            int tmp = data[0];
            data[0] = data[size - 1];
            data[size - 1] = tmp;
            siftDown(0);
            size--;
            return min;
        }
        return -1;
    }
}

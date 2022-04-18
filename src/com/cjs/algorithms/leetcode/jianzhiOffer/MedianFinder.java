package com.cjs.algorithms.leetcode.jianzhiOffer;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
 *
 * 思路：
 *  1.使用动态数组，排序后，求中位数
 *  2.使用两个堆，一个大根堆和一个小根堆，
 *      大根堆存较小的元素（得到排序后中间较小的），小根堆存较大的元素（得到排序后中间较小的）
 *      两个堆一样大，取堆顶求平均，否则取元素较多的堆堆顶
 */
public class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        //默认小根堆中的元素较多，如果数量不一致时
        if (minHeap.size() == maxHeap.size()){
            //放入小根堆，但是不知道num是较大的还是较小的
            //将大根堆中较小的放入小根堆中
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }else{
            //小根堆中的数量较多，放大根堆，不知道大小
            //将小根堆中最小值放入大根堆中
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        return minHeap.size() != maxHeap.size() ?minHeap.peek():(minHeap.peek()+maxHeap.peek())/2.0;
    }
}

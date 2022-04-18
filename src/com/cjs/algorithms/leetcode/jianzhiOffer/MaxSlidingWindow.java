package com.cjs.algorithms.leetcode.jianzhiOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length <= 0)
            return new int[]{};
        int i = 0;
        int j = 0;
        int distance = 1;
        List<Integer> list = new ArrayList<>();
        //使用单调栈存储元素的大小关系，减少复杂度
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(nums[0]);
        while (j < nums.length) {
            if (distance == k) {
                list.add(queue.peekFirst());
                if (!queue.isEmpty() && queue.peekFirst() == nums[i])
                    queue.removeFirst();//将要移除的是最大值
                i++;
                distance--;
            } else if (distance < k) {
                //向单调栈中添加元素,保证单调性
                j++;
                distance++;
                if (j < nums.length){
                    while (!queue.isEmpty() && queue.peekLast() < nums[j]) {
                        queue.removeLast();
                    }
                    queue.addLast(nums[j]);
                }
            }
        }
        int[] result = new int[list.size()];
        for (int l = 0; l < list.size(); l++) {
            result[l] = list.get(l);
        }
        return result;
    }

    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] ints = maxSlidingWindow.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ints));
    }
}

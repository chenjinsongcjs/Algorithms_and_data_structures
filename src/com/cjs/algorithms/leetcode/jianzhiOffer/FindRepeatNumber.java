package com.cjs.algorithms.leetcode.jianzhiOffer;

/**
 * 找出数组中重复的数字。
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 *
 * 思路：使用本地交换，
 * 如果索引和值相等表示归位 i == num[i]
 * 跳过，
 * 如果 num[i] == num[num[i]] 表示之前归位过，时重复的值
 * if i != nums[i] 交换
 */
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i])
                continue;
            if (nums[i] == nums[nums[i]])
                return nums[i];
            while(i != nums[i]){
                if (nums[i] == nums[nums[i]])
                    return nums[i];
                swap(nums,nums[i],i);
            }
        }
        return 0;
    }
    private void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

/*
数字在数字范围内，使用数组索引映射
输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3
[1, 3, 2, 0, 2, 5, 3]
[3, 1, 2, 0, 2, 5, 3]
[0, 1, 2, 3, 2, 5, 3]

往下走
 */
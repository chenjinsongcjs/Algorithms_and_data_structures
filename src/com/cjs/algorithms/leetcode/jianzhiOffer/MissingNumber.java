package com.cjs.algorithms.leetcode.jianzhiOffer;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 按照 num[i] = i 左子数组，num[i] != i 右子数组，
 * 缺失的数字破坏左子数组的关系
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int mid;
        while (i <= j) {
            mid = i + (j - i) / 2;
            if (nums[mid] == mid)
                i = mid + 1;
            else
                j = mid - 1;
        }
        return i;
    }
}

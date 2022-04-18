package com.cjs.algorithms.leetcode.jianzhiOffer;

/**
 * 统计一个数字在排序数组中出现的次数。
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * 思路：找target的左右边界，计算区间长度
 */
public class Search {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length -1;
        int mid;
        while (i <= j){
            mid = i + (j -i ) /2;
            if (nums[mid] <= target)
                i = mid + 1;
            else
                j = mid - 1;
        }
        if (j >= 0 && nums[j] != target)
            return 0;
        int right = i;
        i = 0;
        j = nums.length - 1;
        while (i <= j){
            mid = i + (j -i )/2;
            if (nums[mid] < target)
                i = mid + 1;
            else
                j = mid -1;
        }
        int left = j;
        return right - left -1;
    }
}

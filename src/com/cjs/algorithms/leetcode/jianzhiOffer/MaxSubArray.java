package com.cjs.algorithms.leetcode.jianzhiOffer;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 *
 * 滑动窗口必须为非负数，才可以使用
 *
 * 贪心和动态规划可做
 * -2,1,-3,4,-1,2,1,-5,4
 * 动态规划
 *  dp[i-1] 做负贡献就舍去
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1 ; i < nums.length;i++){
            if(dp[i-1] < 0)
                dp[i] = nums[i];
            else
                dp[i] = dp[i-1] + nums[i];
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}

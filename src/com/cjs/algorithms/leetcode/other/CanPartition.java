package com.cjs.algorithms.leetcode.other;

/**
 * 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。
 * 请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等
 *
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 *
 * 思路：集合中存在和为 sum / 2的子集
 * 转换01背包
 *  1. sum / 2 为背包容量
 *  2.在集合中随机选择的元素能刚好填满背包 i = dp[i]
 */
public class CanPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum & 1) == 1)//奇数不可拆分，不能等和分割
            return false;
        int target  = sum >> 1;
        int[] dp = new int[target+1];
        for (int i = nums[0]; i <=target ; i++)
            dp[i] = nums[0];
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                //物品 i 的重量是 nums[i]，其价值也是 nums[i]
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
        }
        return dp[target] == target;
    }
}

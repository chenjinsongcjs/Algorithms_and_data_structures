package com.cjs.algorithms.leetcode.jianzhiOffer;

import java.lang.management.ManagementFactory;

/**
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。
 * 一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 *
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 *
 * 请你计算并返回达到楼梯顶部的最低花费。
 *https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbingStairs {
    //方法一：动态规划
//    public int minCostClimbingStairs(int[] cost) {
//        int[] dp = new int[cost.length];
//        dp[0] = cost[0];
//        dp[1] = cost[1];
//        for (int i = 2; i < dp.length; i++) {
//            dp[i] = Math.min(dp[i-1],dp[i-2])+cost[i];
//        }
//        //跳上最后一个台阶不用消耗体力，从最后两个台阶选择最小体力消耗
//        return Math.min(dp[dp.length-1],dp[dp.length-2]);
//    }
    //空间优化
    public int minCostClimbingStairs(int[] cost) {
        int a = cost[0];
        int b = cost[1];
        int c = 0;
        for (int i = 2; i < cost.length; i++) {
            c = Math.min(a,b)+cost[i];
            a = b;
            b = c;
        }
        //跳上最后一个台阶不用消耗体力，从最后两个台阶选择最小体力消耗
        return Math.min(a,b);
    }
}

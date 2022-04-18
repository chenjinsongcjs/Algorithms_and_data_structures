package com.cjs.algorithms.leetcode.jianzhiOffer;

/**
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * <p>
 * 返回 你可以获得的最大乘积 。
 * 思路：从1到j，将i拆分为 i -j 和 j
 * 或者 将 i - j进一步拆分
 * dp[i-j] 和 j
 * <p>
 * https://leetcode-cn.com/problems/integer-break/
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if (n < 2)
            return -1;
        int[] dp = new int[n + 1];
        //0 和 1没法拆分，从2开始拆分
        dp[2] = 1;
        //从第三个位置开始
        for (int i = 3; i <= n; i++) {
            //从1开始拆分，i-1 去重1
            for (int j = 1; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(i * (i - j), dp[i - j] * j));
            }
        }
        return dp[n];
    }
}

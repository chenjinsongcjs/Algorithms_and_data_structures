package com.cjs.algorithms.leetcode.jianzhiOffer;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class Fib {
    //    //方法一：使用递归
//    public int fib(int n) {
//        if (n < 2)
//            return n;
//        return fib(n-1)+fib(n-2);
//    }
//    //方法二：动态规划
//    public int fib(int n) {
//        if (n < 2)
//            return n;
//        //确定dp数组和下标的含义
//        int[] dp = new int[n + 1];
//        //初始化dp数组
//        dp[0] = 0;
//        dp[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            //递推公式
//            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
//        }
//        return dp[n];
//    }
    //方法三：动态规划优化空间
    public int fib(int n){
        if (n < 2)
            return n;
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 2; i <= n ; i++) {
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return c;
    }
}

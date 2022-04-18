package com.cjs.algorithms.leetcode.jianzhiOffer;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * 递归，每次把幂次降低一半。
 */
public class MyPow {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        if(n == 1)
            return x;
        if(n == -1)
            return 1 / x;
        double result = myPow(x,n>>1);
        result *= result;
        //奇数，补齐
        if((n & 1) == 1)
            result *= x;
        return result;
    }
}

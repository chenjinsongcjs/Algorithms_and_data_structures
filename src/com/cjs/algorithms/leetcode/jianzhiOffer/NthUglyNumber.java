package com.cjs.algorithms.leetcode.jianzhiOffer;

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * <p>
 * 三指针法：
 * 分别指向，*2 *3 *5 的丑数数组
 * 选择其中最小的放在最终的那个数组中
 * 只要是最小的丑数，指针就往右右移
 */
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        if (n == 0)
            return 0;
        int i = 0, j = 0, k = 0;
        int[] ugly = new int[n+1];
        ugly[1] = 1;
        for (int l = 1; l <= n ; l++) {
            int min = Math.min(ugly[i]*2,Math.min(ugly[j]*3,ugly[k]*5));
            if (min == ugly[i]*2)
                i++;
            if (min == ugly[j]*3)
                j++;
            if (min == ugly[k]*5)
                k++;
        }
        return ugly[n];
    }
}

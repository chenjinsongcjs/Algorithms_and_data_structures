package com.cjs.algorithms.leetcode.jianzhiOffer;

/**
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * <p>
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * <p>
 * https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
 * <p>
 * 找规律
 */
public class CountDigitOne {
    public int countDigitOne(int n) {
        long base = 1;
        int ans = 0;
        while (base <= n) {
            ans += (n / (base * 10)) * base + (Math.min(Math.max(n % (base * 10) - base + 1, 0), base));
            base *= 10;
        }
        return ans;
    }
}

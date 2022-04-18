package com.cjs.algorithms.leetcode.jianzhiOffer;

/**
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），
 * 返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
 */
public class HammingWeight {
    public int hammingWeight(int n) {
//        Integer.bitCount(n); 库函数
        int res = 0;
        int i = 32;
        while(i-- != 0){
            res += n & 1;
            n >>= 1;
        }
        return res;
    }
}

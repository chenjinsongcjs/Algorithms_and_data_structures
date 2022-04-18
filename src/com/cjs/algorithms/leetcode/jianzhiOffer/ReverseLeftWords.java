package com.cjs.algorithms.leetcode.jianzhiOffer;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * 方法1：双倍字符串，从指定位置开始截取
 * 方法2：三次反转
 */
public class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        int length = s.length();
        s = s + s;
        return s.substring(n,n + length);
    }
}

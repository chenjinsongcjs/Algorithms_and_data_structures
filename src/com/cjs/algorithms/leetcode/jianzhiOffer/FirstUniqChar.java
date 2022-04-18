package com.cjs.algorithms.leetcode.jianzhiOffer;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class FirstUniqChar {
    public char firstUniqChar(String s) {
        int[] litters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            litters[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (litters[c - 'a'] == 1)
                return c;
        }
        return ' ';
    }
}

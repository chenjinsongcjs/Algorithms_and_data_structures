package com.cjs.algorithms.leetcode.jianzhiOffer;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        while (j < s.length()) {
            char c = s.charAt(j);
            if (!set.contains(c)) {
                set.add(c);
                j++;
                maxLength = Math.max(maxLength, set.size());
                continue;
            }
            maxLength = Math.max(maxLength, set.size());
            while (i < j && set.contains(c) && s.charAt(i) != c) {
                set.remove(s.charAt(i));
                i++;
            }
            set.remove(s.charAt(i++));
        }
        return maxLength;
    }
}

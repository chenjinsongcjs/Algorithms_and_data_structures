package com.cjs.algorithms.leetcode.jianzhiOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 */
public class Permutation {
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean[] used = new boolean[s.length()];
        backtracking(chars, used);
        String[] res = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    StringBuilder sb = new StringBuilder();
    List<String> result = new ArrayList<>();

    private void backtracking(char[] s, boolean[] used) {
        if (sb.length() == s.length) {
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < s.length; i++) {
            if (used[i] || i > 0 && s[i - 1] == s[i] && !used[i-1])
                continue;
            sb.append(s[i]);
            used[i] = true;
            backtracking(s, used);
            used[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

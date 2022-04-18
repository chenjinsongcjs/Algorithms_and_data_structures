package com.cjs.algorithms.leetcode.jianzhiOffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 字符串切割
 */
public class TranslateNum {
    //动态规划，区间划分【10-25】 2种 其他一种
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for(int i = s.length() - 2; i > -1; i--) {
            String tmp = s.substring(i, i + 2);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }

//    public int translateNum(int num) {
//        backtracking(num+"",0);
//        return result.size();
//    }
//    StringBuilder sb = new StringBuilder();
//    Set<String> result = new HashSet<>();
//    private void backtracking(String num,int starIndex){
//        if (starIndex >= num.length()){
//            result.add(sb.toString());
//            return;
//        }
//
//        for (int i = starIndex; i < num.length(); i++) {
//            String s = num.substring(starIndex, i + 1);
//            if (s.startsWith("0") && s.length() >1)
//                break;
//            int n = Integer.parseInt(s);
//            if (n >= 26)
//                break;
//            sb.append((char) (n+'a'));
//            backtracking(num,i+1);
//            sb.deleteCharAt(sb.length()-1);
//        }
//    }
}


package com.cjs.algorithms.leetcode.jianzhiOffer;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 */
public class ReverseWords {
    public String reverseWords(String s) {
        s = s.trim();
        String[] split = s.split(" ");
        int i = 0;
        int j = split.length -1;
        while (i < j){
            String tmp = split[i].trim();
            split[i] = split[j].trim();
            split[j] = tmp;
            i++;
            j--;
        }
        StringBuilder sb = new StringBuilder();
        for (String value : split) {
            if (!"".equals(value))
            sb.append(value).append(" ");
        }
        if (sb.length() > 0)
            sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}

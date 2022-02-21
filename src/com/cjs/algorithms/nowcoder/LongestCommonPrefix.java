package com.cjs.algorithms.nowcoder;

/**
 * 给你一个大小为 n 的字符串数组 strs ，其中包含n个字符串 ,
 * 编写一个函数来查找字符串数组中的最长公共前缀，返回这个公共前缀。
 * https://www.nowcoder.com/practice/28eb3175488f4434a4a6207f6f484f47?tpId=117&&tqId=37752
 */
//横向扫描，两两求公共前缀
public class LongestCommonPrefix {
    public String longestCommonPrefix (String[] strs) {
        if (strs == null || strs.length == 0)
            return null;
        if (strs.length == 1)
            return strs[0];
        for (int i = 1; i < strs.length; i++) {
            String commonPrefix = commonPrefix(strs[i - 1], strs[i]);
            strs[i] = commonPrefix;
        }
        return strs[strs.length - 1];
    }
    private String commonPrefix(String s1,String s2){
        if (s1 == null || s1.length() ==0)
            return s2;
        if (s2 == null || s2.length() == 0)
            return s1;
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while(i < s1.length() && j < s2.length()){
            if (s1.charAt(i) != s2.charAt(j))
                break;
            sb.append(s1.charAt(i));
            i++;
            j++;
        }
        return sb.toString();
    }
}

package com.cjs.algorithms.nowcoder;

/**
 * 以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
 * 数据范围：len(s),len(t) \le 100000len(s),len(t)≤100000，字符串仅由'0'~‘9’构成
 * 要求：时间复杂度 O(n)O(n)
 * https://www.nowcoder.com/practice/11ae12e8c6fe48f883cad618c2e81475?tpId=196&tqId=37176&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Ftab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196%26page%3D1&difficulty=undefined&judgeStatus=undefined&tags=&title=
 */
//大数加法模板
public class BigNumberAddition {
    public String solve(String s, String t) {
        if (s == null || s.length() == 0)
            return t;
        if (t == null || t.length() == 0)
            return s;
        int i = s.length() - 1;
        int j = t.length() - 1;
        int carry = 0;//记录进位位
        StringBuilder sb = new StringBuilder();
        //不断从个位往前加
        while (i >= 0 || j >= 0) {
            int x = i >= 0 ? s.charAt(i) - '0' : 0;
            int y = j >= 0 ? t.charAt(j) - '0' : 0;
            int sum = x + y + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        if (carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}

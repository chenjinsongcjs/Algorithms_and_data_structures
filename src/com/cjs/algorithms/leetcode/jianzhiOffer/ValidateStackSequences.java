package com.cjs.algorithms.leetcode.jianzhiOffer;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列
 * {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
 * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 * 使用辅助栈模拟,相同出栈
 */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int j = 0;
        for (int k : pushed) {
            stack.addLast(k);//正常压栈
            //遇到同出栈的，跟随出栈
            while (!stack.isEmpty() && stack.peekLast() == popped[j]) {
                stack.removeLast();
                j++;
            }
        }
        return stack.isEmpty();
    }
}

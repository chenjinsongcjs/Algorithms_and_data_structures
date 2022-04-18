package com.cjs.algorithms.leetcode.jianzhiOffer;

import java.util.ArrayDeque;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public class MinStack {

    /** initialize your data structure here. */
    //第一个栈记录普通元素
    ArrayDeque<Integer> stack1;
    //第二个栈记录最小元素
    ArrayDeque<Integer> stack2;
    public MinStack() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void push(int x) {
        stack1.addLast(x);
        if (stack2.isEmpty() || stack2.peekLast() >= x)
            stack2.addLast(x);
    }

    public void pop() {
        int last = stack1.removeLast();
        if ( !stack2.isEmpty() && stack2.peekLast() == last)
            stack2.removeLast();
    }

    public int top() {
        return stack1.isEmpty()? -1 : stack1.peekLast();
    }

    public int min() {
        return stack2.isEmpty()?-1 :stack2.peekLast();
    }
}

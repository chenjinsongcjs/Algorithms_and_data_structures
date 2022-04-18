package com.cjs.algorithms.leetcode.jianzhiOffer;

import java.util.ArrayDeque;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 * <p>
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * <p>
 * * Your CQueue object will be instantiated and called as such:
 * * CQueue obj = new CQueue();
 * * obj.appendTail(value);
 * * int param_2 = obj.deleteHead();
 */
public class CQueue {

    ArrayDeque<Integer> stack1;
    ArrayDeque<Integer> stack2;

    public CQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        stack1.addLast(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while(!stack1.isEmpty())
                stack2.addLast(stack1.removeLast());
        }
        return stack2.isEmpty() ? -1 : stack2.removeLast();
    }
}

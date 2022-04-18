package com.cjs.algorithms.leetcode.jianzhiOffer;

import java.util.ArrayDeque;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，
 * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value需要返回 -1
 *
 */
public class MaxQueue {
    ArrayDeque<Integer> queue1 ;
    ArrayDeque<Integer> queue2;
    public MaxQueue() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

    public int max_value() {
        return queue2.isEmpty() ? -1 :queue2.peekFirst();
    }

    public void push_back(int value) {
        queue1.addLast(value);
        while (!queue2.isEmpty() && queue2.peekLast() < value)
            queue2.removeLast();
        queue2.addLast(value);
    }

    public int pop_front() {
        if (!queue2.isEmpty() && queue2.peekFirst().equals(queue1.peekFirst()))
            queue2.removeFirst();
        return queue1.isEmpty()?-1:queue1.removeFirst();
    }
}

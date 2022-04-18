package com.cjs.algorithms.leetcode.jianzhiOffer;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 * 拼接排序比较
 */
public class MinNumber {
    public String minNumber(int[] nums) {
        return  IntStream.of(nums)
                .boxed()
                .map(Object::toString)
                .sorted((x,y)-> (x+y).compareTo(y+x))
                .reduce("", (x, y) -> x + y);
    }
}

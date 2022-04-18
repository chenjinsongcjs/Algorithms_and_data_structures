package com.cjs.algorithms.leetcode.jianzhiOffer;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素
 *
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 *
 * 思路：
 * 1.map，计数
 * 2.排序后中间的那个数
 * 3.摩尔投票
 *      假设当前数为众数，得票1
 *      如果下一个不是当前众数，票数减一
 *      如果票数为0，换当前数为众数
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int x = nums[0],vote = 0;
        for (int num : nums) {
            if (x == num)
                vote++;
            else {
                vote--;
                if (vote == 0){
                    x = num;
                    vote++;
                }
            }
        }
        return x;
    }
}

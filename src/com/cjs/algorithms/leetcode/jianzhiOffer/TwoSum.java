package com.cjs.algorithms.leetcode.jianzhiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，
 * 使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 * 方法一：使用map存储target和num的关系
 * key 为 target-num
 * value 为 num
 * 如果存在key为num的key即找到一对结果
 *
 * 方法二：
 * 使用双指针
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int i = 0 ;
        int j = nums.length -1;
        int sum = 0;
        while(i <j){
            sum = nums[i]+nums[j];
            if(sum > target)
                j--;
            else if(sum <target)
                i++;
            else
                return new int[]{nums[i],nums[j]};
        }
        return new int[] {};
    }
}

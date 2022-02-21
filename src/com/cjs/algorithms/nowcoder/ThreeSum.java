package com.cjs.algorithms.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。
 * 数据范围：0≤n≤1000，数组中各个元素值满足 val≤100
 * 空间复杂度：O(n^2)时间复杂度 O(n^2)
 * 注意：
 * 三元组（a、b、c）中的元素必须按非降序排列。（即a≤b≤c）
 * 解集中不能包含重复的三元组。
 * 使用三个指定操作，但是要保证有序
 */
public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            if (num[i] > 0)//排序后第一个数大于0，不可能出现三数之和为0
                break;
            //去重
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int sum = num[i] + num[left] + num[right];
                if (sum == 0)
                    list.add(new ArrayList<>(Arrays.asList(num[i], num[left], num[right])));
                else if (sum > 0) {
                    right--;
                    continue;
                } else {//双指针移动
                    left++;
                    continue;
                }
                //去重
                while (left < right && num[left] == num[left + 1])
                    left++;
                while (left < right && num[right] == num[right - 1])
                    right--;
                left++;
                right--;
            }
        }
        return list;
    }
}

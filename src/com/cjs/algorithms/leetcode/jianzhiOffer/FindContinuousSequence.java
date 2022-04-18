package com.cjs.algorithms.leetcode.jianzhiOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列
 * <p>
 * 使用滑动窗口
 */
public class FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> result = new ArrayList<>();
        int i = 1;
        int j = 1;
        int sum = 0;
        while (j < target) {
            if (sum < target) {
                sum += j++;
            } else if (sum > target) {
                sum -= i++;
            } else {
                List<Integer> list = new ArrayList<>();
                //左闭右开区间
                for (int k = i; k < j; k++) {
                    list.add(k);
                }
                result.add(list);
            }
        }
        int[][] r = new int[result.size()][];
        for (int k = 0; k < result.size(); k++) {
            r[k] = new int[result.get(k).size()];
            for (int l = 0; l < result.get(k).size(); l++) {
                r[k][l] = result.get(k).get(l);
            }
        }
        return r;
    }

}

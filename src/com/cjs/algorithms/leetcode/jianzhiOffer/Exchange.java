package com.cjs.algorithms.leetcode.jianzhiOffer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */
public class Exchange {
    public int[] exchange(int[] nums) {
        int i = 0;
        int j = nums.length -1;
        while (i < j ){
            while (i < j && (nums[i] & 1) == 1)
                i++;
            while (i < j && (nums[j] & 1) == 0)
                j--;
            if (i >= j)
                break;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
        return nums;
    }
}

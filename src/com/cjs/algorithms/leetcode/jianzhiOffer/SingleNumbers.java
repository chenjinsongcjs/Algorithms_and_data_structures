package com.cjs.algorithms.leetcode.jianzhiOffer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度是O(n)，空间复杂度是O(1)。
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 *
 * 异或：相同为0，不同为1，与0异或为自己
 * x，y不同至少有一个位是不同的，异或为1，按照这个为将数组分为两个子数组，分别异或得到结果
 */
public class SingleNumbers {
    public int[] singleNumbers_2(int[] nums) {
        int x = 0, y = 0, m = 1, n = 0;
        for(int num : nums){
            n ^= num;//得到 x，y的异或结果
        }
        while ((n & m) == 0){
            m <<= 1;//找到x，y的不同位，按照这个位将数组分为两个
        }
        for (int num:nums){
            if ((num & m) != 0)
                x ^= num;
            else
                y ^= num;
        }
        return new int[]{x,y};
    }
    /**
     * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
     * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
     */
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)){
                map.put(num, 1);
                continue;
            }
            map.put(num, map.get(num) + 1);
        }
        for (Integer next : map.keySet()) {
            if (map.get(next) == 1)
                return next;
        }
        return 0;
    }
}

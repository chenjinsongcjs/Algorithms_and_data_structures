package com.cjs.algorithms.leetcode.jianzhiOffer;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 *
 * 贪心算法
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int ans = 0;
        //每次获取左边的最小值，
        //当前的股票减去最小购入，判断是否是最大利润
        for (int price : prices) {
            minPrice = Math.min(minPrice,price);
            ans = Math.max(ans,price - minPrice);
        }
        return ans;
    }
}

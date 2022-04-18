package com.cjs.algorithms.algorithm_template;

/**
 * 01背包问题
 * https://programmercarl.com/%E8%83%8C%E5%8C%85%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%8001%E8%83%8C%E5%8C%85-1.html
 */
public class BagProblem {
    //01背包二维dp数组实现

    /**
     * @param weight  物品重量数组
     * @param value   物品价值数组
     * @param bagSize 背包能承受的重量
     * @return 返回最大价值
     */
    public int two_wei_bag_Problem(int[] weight, int[] value, int bagSize) {
        //确定dp数组和下表的含义
        //dp[i][j] :表示物品[0-i]之间随机选择物品，放入承受重量为j的背包中的最大价值
        int[][] dp = new int[weight.length][bagSize + 1];
        //初始化，背包重量为0，不能放物品，价值为0,默认值
        //物品编号为0，初始化能装下该物品的背包的价值为0号物品的价值
        for (int j = weight[0]; j <= bagSize; j++)
            dp[0][j] = value[0];
        //递推计算
        //可以先遍历背包，也可以先遍历物品
        for (int i = 1; i < weight.length; i++) {//先遍历物品
            for (int j = 0; j <= bagSize; j++) {//再遍历背包
                if (j < weight[i])
                    dp[i][j] = dp[i - 1][j];//当前物品背包放不下
                else//背包放的下，选择最大价值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
            }
        }
        return dp[weight.length - 1][bagSize];
    }

    public int one_wei_bag_problem(int[] weight, int[] value, int bagSize) {
        //使用一维dp数组实现01背包问题
        int[] dp = new int[bagSize + 1];
        //初始化
        for (int j = weight[0]; j <= bagSize; j++)
            dp[j] = value[0];
        //递推公式遍历
        //一维滚动数组，只能是这个顺序，防止同一个物品重复放置
        for (int i = 0; i < weight.length; i++) {//先遍历物品
            for (int j = bagSize; j >= weight[i]; j--) {//再遍历背包
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[bagSize];
    }
}

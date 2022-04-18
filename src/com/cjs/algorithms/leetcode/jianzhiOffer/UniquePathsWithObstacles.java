package com.cjs.algorithms.leetcode.jianzhiOffer;

/**
 * 一个机器人位于一个m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *https://leetcode-cn.com/problems/unique-paths-ii/
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0)
            return -1;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        //初始化dp数组
        for (int i = 0; i < m && obstacleGrid[i][0] != 1; i++)
            dp[i][0] = 1;
        for (int i = 0; i < n && obstacleGrid[0][i] != 1 ; i++)
            dp[0][i] = 1;
        //递推运算
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    continue;
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}

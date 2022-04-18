package com.cjs.algorithms.leetcode.jianzhiOffer;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
public class MovingCount {
    public int movingCount(int m, int n, int k) {
        boolean[][] used = new boolean[m][n];
        used[0][0] = true;
        backtracking(m,n,k,0,0,used);
        return result;
    }

    int result = 0;
    int[][] point = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    private void backtracking(int m, int n, int k, int a, int b, boolean[][] used) {
        result++;
        for (int[] p : point) {
            int x = a + p[0];
            int y = b + p[1];
            if (x < 0 || x >= m || y < 0 || y >= n || digitalSum(x) + digitalSum(y) > k || used[x][y])
                continue;
            used[x][y] = true;
            backtracking(m, n, k, x, y, used);
//            used[x][y] = false;//不用回溯，去过就不用再去了
        }
    }

    private int digitalSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}

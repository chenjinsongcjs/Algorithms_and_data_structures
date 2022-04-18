package com.cjs.algorithms.leetcode.jianzhiOffer;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[]{};
        //边界控制
        int num = matrix.length*matrix[0].length;
        int[] result = new int[num];
        int l,r,t,b,count = 0;
        //边界定义
        l = 0;
        r = matrix[0].length - 1;
        t = 0;
        b = matrix.length - 1;
        //左闭右开区间
        while (true ){
            //从左向右
            for (int i = l; i <= r; i++) {
                result[count++] = matrix[t][i];
            }
            //先走在做判断
            if (++t > b)
                break;
            //从上到下
            for (int i = t; i <= b ; i++) {
                result[count++] = matrix[i][r];
            }
            if (--r < l)
                break;
            //从右向左
            for (int i = r; i >= l ; i--) {
                result[count++] = matrix[b][i];
            }
            if (--b < t)
                break;
            //从下到上
            for (int i = b; i >= t ; i--) {
                result[count++] = matrix[i][l];
            }
            if (++l > r)
                break;
        }
        return result;
    }
}

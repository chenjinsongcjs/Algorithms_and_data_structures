package com.cjs.algorithms.leetcode.jianzhiOffer;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1]
 * 可能的最大乘积是多少？例如，当绳子的长度是8时，
 * 我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * <p>
 * 整数拆分的思想
 * <p>
 * 遍历1-j,
 * 拆成两个段                    拆成两个以上的段
 * 将i 拆分为 j (i - j) 进一步拆分(i - j)  为 dp[i - j] j
 */
public class CuttingRope {
    public int cuttingRope(int n) {
       if (n <= 3)
            return n -1;
       int res = 1;
       while(n > 4){
           n -= 3;
           res *= 3;
           res %=  1000000007;
       }
       return res * n % 1000000007;
    }
}

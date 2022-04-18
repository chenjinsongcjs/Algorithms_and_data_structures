package com.cjs.algorithms.leetcode.jianzhiOffer;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，
 * 则打印出 1、2、3 一直到最大的 3 位数 999。
 */
public class PrintNumbers {
//    public int[] printNumbers(int n) {
//        int loop = (int) (Math.pow(10,n) - 1);
//        int[] res = new int[loop];
//        for (int i = 0; i < loop; i++) {
//            res[i] = i+1;
//        }
//        return res;
//    }
    //考虑大数情况
    //从高位开始，固定数字，递归到最低为
    char[] num,basicNum = {'0','1','2','3','4','5','6','7','8','9'};
    int n;
    StringBuilder sb = new StringBuilder();
    public String printNumbers(int n) {
        this.n = n;
        dfs(0);
        sb.deleteCharAt(sb.length()-1);//删除最后一个逗号
        return sb.toString();
    }
    //递归放数字
    private void dfs(int x){
        if (x == this.n){
            //位数收集齐全
            String s = String.valueOf(num);
            sb.append(Integer.parseInt(s)+",");
            return;
        }
        for(char c : basicNum){
            num[x]  = c;
            dfs(x + 1);
        }
    }
}

package com.cjs.algorithms.leetcode.jianzhiOffer;

import java.security.PrivilegedExceptionAction;

/**
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；
 * 否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 思路：回溯，暴力搜索
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 *
 * 深度优先遍历，从第一个开始搜索，
 */
public class Exist {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0)
            return false;
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board,word,i,j,0,used))
                    return true;
            }
        }
        return false;
    }
    private boolean exist(char[][] board,String word
            ,int x,int y,int index,boolean[][] used){
        char c = word.charAt(index);
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != c  || used[x][y] )
            return false;
        if (index == word.length() -1)
            return true;

        used[x][y] = true;
        boolean res = exist(board,word,x+1,y,index+1,used)||
                exist(board,word,x-1,y,index+1,used)||
                exist(board,word,x,y+1,index+1,used)||
                exist(board,word,x,y-1,index+1,used);
        used[x][y] = false;
        return res;

    }


}

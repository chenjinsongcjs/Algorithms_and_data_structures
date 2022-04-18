package com.cjs.algorithms.leetcode.jianzhiOffer;

/**
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 *
 * 中序遍历：从小到大   左 根 右
 * 反向中序遍历：从大到小  右 根 左
 */
public class KthLargest {
    int k,n,value;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        getKValue(root);
        return value;
    }
    private void getKValue(TreeNode root){
        if (root == null)
            return;
        getKValue(root.right);
        n++;
        if (k == n){
            value = root.val;
            return;
        }
        getKValue(root.left);
    }
}

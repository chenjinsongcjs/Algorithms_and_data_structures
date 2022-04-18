package com.cjs.algorithms.leetcode.jianzhiOffer;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSame(root.left,root.right);
    }
    private boolean isSame(TreeNode A,TreeNode B){
        if (A == null && B == null)
            return true;
        if (A == null || B == null)
            return false;
       if (A.val != B.val)
           return false;
       return isSame(A.left,B.right) && isSame(A.right,B.left);
    }
}

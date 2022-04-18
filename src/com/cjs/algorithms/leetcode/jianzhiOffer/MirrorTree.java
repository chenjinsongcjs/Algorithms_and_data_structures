package com.cjs.algorithms.leetcode.jianzhiOffer;


/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * <p>
 * 从底向上一次反转
 */
public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }
}

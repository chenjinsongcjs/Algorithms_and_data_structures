package com.cjs.algorithms.leetcode.jianzhiOffer;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight-rightHeight) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    private int getHeight(TreeNode root){
        if (root == null)
            return 0;
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }
}

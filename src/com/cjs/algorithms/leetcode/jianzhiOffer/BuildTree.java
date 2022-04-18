package com.cjs.algorithms.leetcode.jianzhiOffer;



/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * <p>
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * 思路：递归构建
 * 在前序遍历中确定根节点，在中序遍历中拆分左右子树
 * 左闭右开区间
 */
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,0,preorder.length,inorder,0,inorder.length);
    }
    //指定好中序左数组和中序右数组，指定好前序左数组和前序右数组
    private TreeNode buildTree(int[] preorder,int preorderBegin,int preorderEnd,
                               int[] inorder,int inorderBegin,int inorderEnd){
        if (preorderBegin == preorderEnd)
            return null;//遍历完所有节点

        //截取根节点元素
        int rootValue = preorder[preorderBegin];
        TreeNode root = new TreeNode(rootValue);
        //叶子节点
        if (preorderBegin + 1 == preorderEnd)
            return root;
        //使用根元素，在中序数组，拆分左右子树
        int delimiterIndex = 0;
        for (int i = inorderBegin; i < inorderEnd; i++) {
            if (inorder[i] == rootValue){
                delimiterIndex = i;//获取拆分点
                break;
            }
        }
        //更新区间，前序数组
        //前序左数组
        int leftPreorderBegin = preorderBegin + 1;
        int leftPreorderEnd = leftPreorderBegin + delimiterIndex - inorderBegin;
        //前序右数组
        int rightPreorderBegin = leftPreorderEnd ;
        int rightPreorderEnd = preorderEnd;
        //更新中序数组
        int leftInorderBegin = inorderBegin;
        int leftInorderEnd = delimiterIndex;
        //中序右数组
        int rightInorderBegin = delimiterIndex + 1;
        int rightInorderEnd = inorderEnd;
        //递归左右子树
        root.left = buildTree(preorder,leftPreorderBegin,leftPreorderEnd,inorder,leftInorderBegin,leftInorderEnd);
        root.right = buildTree(preorder,rightPreorderBegin,rightPreorderEnd,inorder,rightInorderBegin,rightInorderEnd);
        return root;
    }
}
/*
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
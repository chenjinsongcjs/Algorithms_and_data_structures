package com.cjs.algorithms.leetcode.jianzhiOffer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。
 * 假设输入的数组的任意两个数字都互不相同。
 * <p>
 * 左 右 根   根据遍历的规律划分区间
 * 1.从左到右找到第一个大于根的节点，就是左右子树的分界点
 * 2.左子树在找大于根节点时，就验证了正确性
 * 3.只要验证右子树区间是否为二叉搜索树即可
 */
public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {

        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    private boolean verifyPostorder(int[] postorder, int i, int j) {
        if (i >= j)//区间验证结束，或只含有一个节点
            return true;
        int p = i;
        //找到第一个大于根节点的位置，并且验证左子树
        while (postorder[p] < postorder[j])
            p++;
        int m = p;//找到第一个大于根节点的位置
        while (postorder[p] > postorder[j])
            p++;//验证右子树，如果跳出p没有到根节点的位置那么，就没有构成一个二叉搜索树
        return (p == j) && verifyPostorder(postorder, i, m - 1) &&
                verifyPostorder(postorder, m, j - 1);

    }
}

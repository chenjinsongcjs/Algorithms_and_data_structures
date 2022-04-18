package com.cjs.algorithms.leetcode.jianzhiOffer;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 */
public class IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //在AB不为空的时候，比较AB，A的左子树与B，右子树和B
        return (A != null && B != null) && (recur(A,B) ||
                isSubStructure(A.left,B) ||
                isSubStructure(A.right,B));
    }
    //比较A ，B两棵树
    private boolean recur(TreeNode A,TreeNode B){
        if (B == null)
            return true;//B遍历完毕
        if (A == null || A.val != B.val)
            return false;//A 遍历完，B没有遍历完，AB值不相等
        return recur(A.left,B.left) && recur(A.right,B.right);
    }
}

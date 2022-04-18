package com.cjs.algorithms.leetcode.jianzhiOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，
 * 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 *
 * 回溯
 */
public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        backtracking(root,target);
        return result;
    }
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    private void backtracking(TreeNode root,int target){
        if (root == null)
            return;
        target -= root.val;
        path.add(root.val);
        if (target == 0 && root.left == null &&root.right ==null)
            result.add(new ArrayList<>(path));
        backtracking(root.left,target);
        backtracking(root.right,target);
        path.remove(path.size()-1);
    }
}

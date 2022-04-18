package com.cjs.algorithms.leetcode.jianzhiOffer;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。
 * 这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
 *
 *  层序遍历实现
 */
public class Codec {
    // Encodes a tree to a single string.
    //格式:[1,2,3,null,null,null,null]
    public String serialize(TreeNode root) {
        if (root == null)
            return "[]";
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            if (node != null){
                sb.append(node.val);
                sb.append(",");
                queue.add(node.left);
                queue.add(node.right);
            }else {
                sb.append("null,");
            }
        }
        //删除最后一个逗号
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    //层序遍历反序列化
    public TreeNode deserialize(String data) {
        String[] split = data.substring(1, data.length() - 1).split(",");
        if (split.length == 0)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        queue.add(root);
        int i = 1;//遍历数组
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            if (!split[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(split[i]));
                queue.add(node.left);
            }
            i++;
            if (!split[i].equals("null")){
                node.right = new TreeNode(Integer.parseInt(split[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}

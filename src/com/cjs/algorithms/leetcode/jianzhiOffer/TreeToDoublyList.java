package com.cjs.algorithms.leetcode.jianzhiOffer;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 *
 * 中序遍历处理,当前节点和前驱节点
 */
public class TreeToDoublyList {
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        pre.right = head;
        head.left = pre;
        return head.left;
    }
    Node pre,head;
    private void toList(Node root){
        if (root == null)
            return;
        toList(root.left);
        if (pre == null)//链表的钱去节点
            head = root;
        else
            pre.right = root;
        root.left = pre;
        pre = root;
        toList(root.right);
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
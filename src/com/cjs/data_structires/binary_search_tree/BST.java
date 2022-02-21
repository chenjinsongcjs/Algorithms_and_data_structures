package com.cjs.data_structires.binary_search_tree;

import com.cjs.data_structires.arrays.Array;
import com.cjs.data_structires.queue.ArrayQueue;
import com.cjs.data_structires.stack.ArrayStack;

/**
 * 二叉树的介绍：
 * 1.二叉树只有一个根节点
 * 2.天然递归，左子树是一颗二叉树，右子树也是一颗二叉树
 * 3.null也是一颗二叉树，一个节点也是一颗二叉树
 * <p>
 * <p>
 * 二分搜索树的介绍
 * 1. BST的每个节点的值：
 * 大于左子树的节点值
 * 小于右子树的节点值
 * 2.BST的每一课子树也是一颗BST
 * 3.BST存储的元素必须是可以比较的实现Comparable接口
 * 4.目前实现的二叉树没有包含重复的元素
 */
public class BST<E extends Comparable<E>> {
    //二叉树的节点
    private class Node {
        E data;
        Node left;
        Node right;

        public Node(E data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node(E data) {
            this(data, null, null);
        }

        public Node() {
            this(null);
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    //以node为根节点向二叉树中添加元素，递归算法
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.data) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.data) > 0)
            node.right = add(node.right, e);
        return node;
    }

    //判断BST中是否包含指定元素
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null)
            return false;
        if (e.compareTo(node.data) == 0)
            return true;
        else if (e.compareTo(node.data) < 0)
            return contains(node.left, e);
        else
            return contains(node.right, e);
    }

    //二叉树的遍历  递归版本
    //前序遍历
    public void preOrder() {
//        preOrder(root);
        preOrder_non(root);
    }

    //根左右
    private void preOrder(Node node) {
        if (node == null)
            return;
        System.out.println(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    //中序遍历：左根右
    public void inOrder() {
//        inOrder(root);
        inOrder_non(root);
    }

    private void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node);
        inOrder(node.right);
    }

    //后序遍历:左右根
    public void postOrder() {
//        postOrder(root);
        postOrder_non(root);
    }

    private void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node);
    }

    public void levelOrder() {
        levelOrder(root);
    }

    //层序遍历：使用辅助队列
    private void levelOrder(Node node) {
        ArrayQueue<Node> queue = new ArrayQueue<>();
        if (node == null)
            return;
        queue.enQueue(node);
        while (!queue.isEmpty()) {
            Node node1 = queue.deQueue();
            System.out.println(node1);
            if (node1.left != null)
                queue.enQueue(node1.left);
            if (node1.right != null)
                queue.enQueue(node1.right);
        }
    }

    //遍历非递归
    //前序遍历:使用栈作为辅助
    private void preOrder_non(Node node) {
        ArrayStack<Node> stack = new ArrayStack<>();
        if (node == null)
            return;
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node1 = stack.pop();
            System.out.println(node1);
            if (node1.right != null)
                stack.push(node1.right);
            if (node1.left != null)
                stack.push(node1.left);
        }
    }

    //中序遍历非递归：使用栈
    private void inOrder_non(Node node) {
        ArrayStack<Node> stack = new ArrayStack<>();
        Node cur = node;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {//左子树一致压栈
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                System.out.println(cur);
                cur = cur.right;
            }
        }
    }

    //后序遍历: 根右左  --> 逆序 左右根
    private void postOrder_non(Node node) {
        ArrayStack<Node> stack = new ArrayStack<>();
        Array<Node> array = new Array<>();
        if (node == null)
            return;
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node1 = stack.pop();
            array.addLast(node1);
            if (node1.left != null)
                stack.push(node1.left);
            if (node1.right != null)
                stack.push(node1.right);
        }
        array.reverse();
        System.out.println(array);
    }

    //BST删除部分
    //删除BST中的最大值,最大值为最右节点
    public E removeMax() {
        E max = findMax(root);
        root = removeMax(root);
        return max;
    }

    private Node removeMax(Node node) {
        if (node == null)
            return null;
        if (node.right == null) {//找到最大值节点
            Node delNodeLeft = node.left;
            node.left = null;
            size--;
            return delNodeLeft;
        }
        node.right = removeMax(node.right);
        return node;
    }

    private E findMax(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.data;
    }

    //删除BST中的最小值，最小值为最左节点
    public E removeMin() {
        E min = findMin(root).data;
        root = removeMin(root);
        return min;
    }

    private Node findMin(Node node) {
        if (node == null)
            return null;
        if (node.left == null) {
            return node;
        }
        return findMin(node.left);
    }

    private Node removeMin(Node node) {
        if (node == null)
            return null;
        if (node.left == null) {
            size--;
            Node delNodeRight = node.right;
            node.right = null;
            return delNodeRight;
        }
        node.left = removeMin(node.left);//接住，下一层的返回值
        return node;
    }

    //真正的删除
    //删除指定元素
    public void removeElement(E e) {
        root = removeElement(root, e);//在root为根的二叉树中删除指定元素
    }

    /**
     * 情况分析：
     * 1.叶子节点直接删除
     * 2.只有左子树或者右子树，上一层直接连接他的左子树或者右子树
     * 3.含有左右子树，用其右子树中的最左节点（右子树中最小值）替换当前节点，
     * 或者使用左子树中的最右节点替换当前节点
     *
     * @param node
     * @param e
     * @return
     */
    private Node removeElement(Node node, E e) {
        if (node == null)
            return null;
        //先定位，再删
        if (e.compareTo(node.data) < 0) {
            node.left = removeElement(node.left, e);//接住下一层
            return node;
        } else if (e.compareTo(node.data) > 0) {
            node.right = removeElement(node.right, e);//接住下一层返回值
            return node;
        } else {
            //找到要删除的节点，直接删除。
            if (node.right == null) {
                //左子树不为空，右子树为空
                size--;
                Node delNodeLeft = node.left;
                node.left = null;
                return delNodeLeft;
            }
            if (node.left == null) {
                //右子树不为空，左子树为空
                size--;
                Node delNodeRight = node.right;
                node.right = null;
                return delNodeRight;
            }
            //左右子树都不为空
            Node min = findMin(node.right);
            min.right = removeMin(node.right);
            min.left = node.left;
            node.left = node.right = null;
            return min;

        }
    }


    //二叉树的打印
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res) {

        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.data + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++)
            res.append("--");
        return res.toString();
    }
}

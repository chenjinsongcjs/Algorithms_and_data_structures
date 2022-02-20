package com.cjs.avl_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 手写AVLTree,方便实现Map使用kv键值对
 *
 * @param <K>
 * @param <V>
 */
public class AVLTree<K extends Comparable<K>, V> {
    private class Node {
        K key;
        V value;
        Node left;
        Node right;
        int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;//叶子节点的高度为1
        }

        public Node() {
            this(null, null);
        }
    }

    private Node root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    //辅助函数
    //获取当前节点的高度
    private int getHeight(Node node){
        return node == null?0:node.height;
    }
    //获取当前节点的平衡因子：左子树高度-右子树高度
    private int getBalance(Node node){
        if (node == null)
            return 0;
        return getHeight(node.left) - getHeight(node.right);
    }
    //判断一颗树是否是二叉搜索树,中序遍历是有序的
    public boolean isBST(){
        List<K> keys = new ArrayList<>();
        inOrder(root,keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i -1).compareTo(keys.get(i)) > 0){
                return false;
            }
        }
        return true;
    }
    private void inOrder(Node node,List<K> list) {
        if (node == null)
            return;
        inOrder(node.left,list);
        list.add(node.key);
        inOrder(node.right,list);
    }
    //判断是否为平衡二叉树
    public boolean isBalance(){
        return isBalance(root);
    }
    private boolean isBalance(Node node){
        if (node == null)
            return true;
        //判断当前节点
        int balance = getBalance(node);
        if (Math.abs(balance) > 1)
            return false;
        //判断左右子树是否平衡
        return isBalance(node.left) && isBalance(node.right);
    }
    //添加元素
    public void add(K ket,V value){
        root = add(root,ket,value);
    }


    //维持平衡的操作
    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    //右旋转
    private Node rightRotate(Node y){
        Node x = y.left;
        Node t3 = x.right;
        //旋转
        x.right = y;
        y.left = t3;
        //更新高度
        y.height = 1 + Math.max(getHeight(y.left),getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left),getHeight(x.right));
        return x;
    }
    //左旋转
    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    private Node leftRotate(Node y){
        Node x = y.right;
        Node t2 = x.left;
        //旋转
        x.left = y;
        y.right = t2;
        //更新高度
        y.height = 1 + Math.max(getHeight(y.left),getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left),getHeight(x.right));
        return x;
    }

    //返回添加元素后的根节点
    private Node add(Node node,K key,V value){
        if (node == null){
            size++;
            return new Node(key,value);
        }
        if (key.compareTo(node.key) < 0){
            node.left = add(node.left,key,value);
        }else if (key.compareTo(node.key) >0 ){
            node.right = add(node.right,key,value);
        }else {
            node.value = value;
        }
        //递归更新高度，
        node.height = 1 + Math.max(getHeight(node.left),getHeight(node.right));
        int balance = getBalance(node);
        //LL,if判断方向
        if (balance > 1 && getBalance(node.left) >= 0){
            return rightRotate(node);
        }
        //RR
        if (balance < -1 && getBalance(node.right) <= 0){
            return leftRotate(node);
        }
        //LR
        if (balance > 1 && getBalance(node.left) > 0){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && getBalance(node.right) > 0){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
    //删除元素
    public V remove(K key){
        V v = get(key);
        root = remove(root, key);
        return v;
    }
    //返回删除元素后的最新根节点
    private Node remove(Node node,K key){
        if (node == null)
            return null;
        Node retNode;//对返回的根节点进行同意处理
        if (key.compareTo(node.key) < 0){
            node.left = remove(node.left,key);
            retNode = node;
        }else if (key.compareTo(node.key) > 0){
            node.right = remove(node.right,key);
            retNode = node;
        }else {
            //删除开始
            if (node.left == null){
                Node rightNode = node.right;
                size--;
                node.right = null;
                retNode = rightNode;
            }else if (node.right == null){
                Node leftNode = node.left;
                size--;
                node.left = null;
                retNode = leftNode;
            }else{
                //删除含有左右孩子的节点
                Node min = findMin(node.right);
                min.right = remove(node.right,min.key);
                min.left = node.left;
                node.left = node.right = null;
                retNode = min;
            }
        }
        //删除叶子节点不用平衡处理
        if (retNode == null)
            return null;
        //维持自平衡
        retNode.height = 1 + Math.max(getHeight(retNode.left),getHeight(retNode.right));
        int balance = getBalance(retNode);
        if (balance > 1 && getBalance(node.left) >= 0)
            return rightRotate(retNode);
        if (balance < -1 && getBalance(retNode.right) <= 0)
            return leftRotate(retNode);
        if (balance > 1 && getBalance(retNode.left) < 0){
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }
        if (balance < -1 && getBalance(retNode.right) > 0){
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }

        return retNode;
    }
    private Node findMin(Node node){
        if (node == null)
            return null;
        if (node.left == null){
            return node;
        }
        return findMin(node.left);
    }
    // 返回以node为根节点的二分搜索树中，key所在的节点
    private Node getNode(Node node, K key){

        if(node == null)
            return null;

        if(key.equals(node.key))
            return node;
        else if(key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else // if(key.compareTo(node.key) > 0)
            return getNode(node.right, key);
    }

    public boolean contains(K key){
        return getNode(root, key) != null;
    }

    public V get(K key){

        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public void set(K key, V newValue){
        Node node = getNode(root, key);
        if(node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");

        node.value = newValue;
    }
}

package com.cjs.data_structires.trie;

import java.util.TreeMap;

/**
 * 字典树：可以做敏感词过滤
 */
public class Trie {
    private class Node{
        boolean isWorld;//判断到当前位置为止是否是一个单词
        TreeMap<Character,Node> next;//指向下一个节点
        public Node(boolean isWorld){
            this.isWorld = isWorld;
            next = new TreeMap<>();
        }
        public Node(){
            this(false);
        }
    }
    //Trie的根节点
    private Node root;
    //记录单词的个数
    private int size;
    public Trie(){
        //根节点为，一个什么都没有的节点
        root = new Node();
        size = 0;
    }
    public int getSize() {
        return size;
    }
    //添加元素
    public void add(String word){
        Node cur = root;//根没有存储任何东西
        for (int i = 0; i < word.length(); i++) {
            char c  = word.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c,new Node());
            cur = cur.next.get(c);
        }
        if (!cur.isWorld){
            cur.isWorld = true;
            size++;
        }
    }
    //判断单词是否在Trie树中,每一个字母都是保存在树干上的，
    public boolean contains(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWorld;
    }
    // 查询是否在Trie中有单词以prefix为前缀
    public boolean isPrefix(String prefix){
        Node cur = root;
        for(int i = 0 ; i < prefix.length() ; i ++){
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }

        return true;
    }
}

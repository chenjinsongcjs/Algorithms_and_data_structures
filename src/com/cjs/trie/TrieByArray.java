package com.cjs.trie;

public class TrieByArray {
    private class Node{
        boolean isword;
        Node[] next;

        public Node(boolean isword) {
            this.isword = isword;
            next = new Node[26];
        }
        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public TrieByArray() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }
    public void add(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c= word.charAt(i);
            if (cur.next[c - 'a'] == null)
                cur.next[c - 'a'] = new Node();
             cur = cur.next[c - 'a'];
        }
        if (!cur.isword){
            cur.isword = true;
            size++;
        }
    }
    public boolean contains(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c= word.charAt(i);
            if (cur.next[c - 'a'] == null)
               return false;
            cur = cur.next[c - 'a'];
        }
        return cur.isword;
    }
}

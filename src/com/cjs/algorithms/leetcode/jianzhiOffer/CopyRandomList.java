//package com.cjs.algorithms.leetcode.jianzhiOffer;
//
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，
// * 每个节点除了有一个 next 指针指向下一个节点，
// * 还有一个 random 指针指向链表中的任意节点或者 null
// * <p>
// * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
// * <p>
// * 思路：random指针的指向，
// */
//public class CopyRandomList {
//    public Node copyRandomList(Node head) {
//
//        Node dummyHead = new Node(0);
//        Node q = dummyHead;
//        Node p = head;
//        Map<Node, Node> map = new HashMap<>();
//        while (p != null) {
//            Node node = new Node(p.val);
//            q.next = node;
//            q = q.next;
//            map.put(p, node);//创建当前节点和新建节点之间的映射
//            p = p.next;
//        }
//        p = head;
//        q = dummyHead.next;
//        while (p != null) {
//            q.random = map.get(p.random);
//            p = p.next;
//            q = q.next;
//        }
//
//        return dummyHead.next;
//    }
//}
//
//class Node {
//    int val;
//    Node next;
//    Node random;
//
//    public Node(int val) {
//        this.val = val;
//        this.next = null;
//        this.random = null;
//    }
//}

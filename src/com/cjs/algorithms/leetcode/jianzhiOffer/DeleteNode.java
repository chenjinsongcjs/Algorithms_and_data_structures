package com.cjs.algorithms.leetcode.jianzhiOffer;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 */
public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;
        while (p != null && p.next != null) {
            if (p.next.val == val) {
                ListNode delNode = p.next;
                p.next = delNode.next;
                delNode.next = null;
            }
            p = p.next;
        }
        return dummyHead.next;

    }
}

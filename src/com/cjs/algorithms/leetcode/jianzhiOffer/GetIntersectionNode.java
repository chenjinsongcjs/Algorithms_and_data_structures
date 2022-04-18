package com.cjs.algorithms.leetcode.jianzhiOffer;

import java.util.List;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        ListNode p = lengthA > lengthB ? headA:headB;
        ListNode q = lengthA >= lengthB ? headB:headA;
        int i = 0;
        while (p != null){
            if (p == q)
                return p;
            if (i >= Math.abs(lengthA-lengthB)){
                q = q.next;
            }
            i++;
            p = p.next;
        }
        return null;
    }
    private int getLength(ListNode head){
        if (head == null)
            return 0;
        int length = 0;
        while (head != null){
            length++;
            head = head.next;
        }
        return length;
    }
}

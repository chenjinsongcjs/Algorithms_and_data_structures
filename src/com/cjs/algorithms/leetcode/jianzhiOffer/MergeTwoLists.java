package com.cjs.algorithms.leetcode.jianzhiOffer;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        //开一个新的链表，接在头上
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                p.next = l1;
                l1 = l1.next;
                p = p.next;
                p.next = null;
            }else {
                p.next = l2;
                l2 = l2.next;
                p = p.next;
                p.next = null;
            }
        }
        if (l1 != null)
            p.next = l1;
        if (l2 != null)
            p.next = l2;
        return dummyHead.next;
    }
}

package com.cjs.algorithms.leetcode.jianzhiOffer;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，
 * 本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，
 * 它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 */
public class GetKthFromEnd {
    //快慢指针
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        int i = 0;
        while(fast != null){
            if (i >= k){
                slow = slow.next;
            }
            i++;
            fast = fast.next;
        }
        return slow;
    }
}

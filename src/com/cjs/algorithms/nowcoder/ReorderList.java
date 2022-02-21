package com.cjs.algorithms.nowcoder;

/**
 * 将给定的单链表: L: L0 --> l1 --> .... --> Ln-1 -->Ln
 * 重新排序为：L: L0 --> Ln --> L1 -->Ln-1 -->.....
 * 要求使用原地算法，不能只改变节点内部的值，需要对实际的节点进行交换。
 * 要求：空间复杂度 O(n)O(n) 并在链表上进行操作而不新建链表，时间复杂度 O(n)O(n)
 * 进阶：空间复杂度 O(1)O(1) ， 时间复杂度 O(n)O(n)
 * https://www.nowcoder.com/practice/3d281dc0b3704347846a110bf561ef6b?tpId=196&rp=1&ru=%2Fexam%2Foj&qru=%2Fexam%2Foj&sourceUrl=%2Fexam%2Foj%3Ftab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196%26page%3D1&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
 */
//思路：将链表拆成两个链表，将最后的链表反转，将反转后的链表，插入到第一个链表中
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null)
            return;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode reverse = reverse(slow.next);
        slow.next = null;
        ListNode p = head;
        while (reverse != null){
            ListNode q = p.next;
            p.next = reverse;
            ListNode r = reverse.next;
            reverse.next = q;
            p = q;
            reverse = r;
        }
    }
    private ListNode reverse(ListNode listNode){
        ListNode pre = null;
        ListNode cur = listNode;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

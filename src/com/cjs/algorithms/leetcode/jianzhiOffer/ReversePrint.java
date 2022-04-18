package com.cjs.algorithms.leetcode.jianzhiOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        reversePrint(head,list);
        int[] result =  new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    private void  reversePrint(ListNode head,List<Integer> list){
        if (head == null)
            return;
        reversePrint(head.next,list);
        list.add(head.val);

    }
}
//方法一使用递归


//方法二使用反转链表
//int num = 0;
//    public int[] reversePrint(ListNode head) {
//        ListNode reverse = reverse(head);
//        int[] result = new int[num];
//        int i = 0;
//        while (reverse != null){
//            result[i++] = reverse.val;
//            reverse = reverse.next;
//        }
//        return result;
//    }
//    private ListNode reverse(ListNode node){
//        ListNode pre = null;
//        ListNode cur = node;
//        while (cur != null){
//            num++;
//            ListNode next  = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//        return pre;
//    }

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
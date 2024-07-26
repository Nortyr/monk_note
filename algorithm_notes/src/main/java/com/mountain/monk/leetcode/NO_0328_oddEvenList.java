package com.mountain.monk.leetcode;

import java.util.*;

public class NO_0328_oddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {return head;}
        ListNode first = new ListNode(0);
        ListNode second = new ListNode(0);
        ListNode   cur = head;
        ListNode next = cur.next;
        first.next=cur;
        second.next=next;
        ListNode pre1 = null;
        ListNode pre2 = null;
        while (cur.next != null&&next.next != null) {
            pre1=cur;
            pre2=next;
            cur=next.next;
            next=cur==null?null:cur.next;
            pre1.next=cur;
            pre2.next=next;
        }
        cur.next=second.next;
        return first.next;

    }
}

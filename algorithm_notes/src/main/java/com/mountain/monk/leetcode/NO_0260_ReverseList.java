package com.mountain.monk.leetcode;

public class NO_0260_ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur=next;
        }
        return pre;
    }
}

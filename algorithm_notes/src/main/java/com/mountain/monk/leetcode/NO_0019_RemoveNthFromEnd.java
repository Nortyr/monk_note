package com.mountain.monk.leetcode;

public class NO_0019_RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode fast=preHead;
        ListNode slow=preHead;

        for (int i = 0; fast!=null; i++) {
            fast=fast.next;
            if(i>n) {
                slow=slow.next;
            }
        }
        slow.next=slow.next.next;
        return preHead.next;
    }
}

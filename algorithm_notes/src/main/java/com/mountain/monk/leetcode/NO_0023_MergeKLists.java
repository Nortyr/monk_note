package com.mountain.monk.leetcode;

import java.util.PriorityQueue;

public class NO_0023_MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((a,b)->{
            return a.val - b.val;
        });
        for (ListNode node : lists) {
            ListNode cur = node;
            while (cur != null) {
                queue.offer(cur);
            }
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (!queue.isEmpty()) {
            ListNode tmp = queue.poll();
            cur.next = tmp;
            cur = cur.next;
        }
        return head.next;
    }
}

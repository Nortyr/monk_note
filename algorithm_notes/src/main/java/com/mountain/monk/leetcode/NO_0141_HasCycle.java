package com.mountain.monk.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NO_0141_HasCycle {
    public boolean hasCycle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            if (list.contains(cur)) {
                return true;
            }
            list.add(cur);
            cur = cur.next;
        }
        return false;
    }
}

package com.mountain.monk.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NO_0160_GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA !=  pB ) {
            pA = pA==null?headB:pA.next;
            pB = pB==null?headA:pB.next;

        }
        return pA;



    }

    private static ListNode getListNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        List<ListNode> listA = new ArrayList<>();
        while (pA != null) {
            listA.add(pA);
            pA = pA.next;
        }
        ListNode pB = headB;
        while (pB != null) {
            if (listA.contains(pB)) {
                return pB;
            }
            pB = pB.next;
        }
        return null;
    }
}

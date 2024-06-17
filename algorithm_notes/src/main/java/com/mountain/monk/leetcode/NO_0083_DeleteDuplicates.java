package com.mountain.monk.leetcode;

public class NO_0083_DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode tmpStart=new ListNode(-1);
        tmpStart.next=head;
        ListNode cur=head;
        ListNode pre=null;
        while (cur!=null){
            if(pre!=null&&pre.val==cur.val){
                cur=cur.next;
                pre.next=cur;
                continue;
            }
            pre=cur;
            cur=cur.next;

        }

        return tmpStart.next;

    }
}

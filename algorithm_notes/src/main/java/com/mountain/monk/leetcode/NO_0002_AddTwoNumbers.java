package com.mountain.monk.leetcode;

public class NO_0002_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre=null;
        ListNode curL=l1;
        ListNode curR=l2;
        ListNode head=new ListNode(-1);
        ListNode cur=null;
        boolean flag=false;
        while(curL!=null&&curR!=null){
            int val=curL.val+curR.val;
            val = flag?val+1:val;
            flag=false;
            if(val>=10){
                flag=true;
                val=val%10;
            }
            head.next=new ListNode(val);
            head.next.next=cur;
            cur=head.next;
            curL=curL.next;
            curR=curR.next;
        }

        while (curL!=null){
            int val=curL.val;
            val = flag?val+1:val;
            flag=false;
            if(val>=10){
                flag=true;
                val=val%10;
            }
            head.next=new ListNode(val);
            head.next.next=cur;
            cur=head.next;
            curL=curL.next;

        }

        while (curR!=null){
            int val=curR.val;
            val = flag?val+1:val;
            flag=false;
            if(val>=10){
                flag=true;
                val=val%10;
            }
            head.next=new ListNode(val);
            head.next.next=cur;
            cur=head.next;
            curR=curR.next;

        }

        if(flag){
            head.next=new ListNode(1);
            head.next.next=cur;
            cur=head.next;
        }

        ListNode result=reverse(head.next);
        return result;
    }

    private ListNode reverse(ListNode cur) {

        if(cur==null||cur.next==null){
            return cur;
        }

        ListNode pre=null;
        ListNode curr=cur;
        ListNode next=null;
        while (curr.next!=null){
            next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        curr.next=pre;
        return curr;

    }

}

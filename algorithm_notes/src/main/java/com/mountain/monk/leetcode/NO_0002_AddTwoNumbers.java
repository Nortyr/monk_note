package com.mountain.monk.leetcode;

public class NO_0002_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre=null;
        ListNode curL=l1;
        ListNode curR=l2;
        ListNode head=new ListNode(-1);
        ListNode temp=head;
        int preVal=0;
        while(curL!=null && curR!=null){
            int sum=curL.val+curR.val+preVal;
            preVal=sum/10;
            int cur=sum%10;
            temp.next=new ListNode(cur);
            temp=temp.next;
            curL=curL.next;
            curR=curR.next;
        }
        while(curL!=null ){
            int sum=curL.val+preVal;
            preVal=sum/10;
            int cur=sum%10;
            temp.next=new ListNode(cur);
            temp=temp.next;
            curL=curL.next;
        }
        while(curR!=null ){
            int sum=curR.val+preVal;
            preVal=sum/10;
            int cur=sum%10;
            temp.next=new ListNode(cur);
            temp=temp.next;
            curR=curR.next;
        }
        if(preVal>0){
            temp.next=new ListNode(preVal);
            temp=temp.next;
        }

        return head.next;
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

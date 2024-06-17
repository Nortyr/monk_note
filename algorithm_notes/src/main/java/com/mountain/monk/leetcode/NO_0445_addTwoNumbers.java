package com.mountain.monk.leetcode;

import java.util.LinkedList;

public class NO_0445_addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<ListNode> list1=new LinkedList<>();
        LinkedList<ListNode> list2=new LinkedList<>();

        while (l1!=null){
            list1.addFirst(l1);
            l1=l1.next;
        }
        while (l2!=null){
            list2.addFirst(l2);
            l2=l2.next;
        }

        int tmp=0;
        ListNode pre=null;
        while (!list1.isEmpty()&&!list2.isEmpty()){
            ListNode node1=list1.pop();
            ListNode node2=list2.pop();
            ListNode cur=new ListNode((node2.val+node1.val+tmp)%10);
            tmp=(node2.val+node1.val+tmp)/10;
            cur.next=pre;
            pre=cur;
        }
        while (!list1.isEmpty()){
            ListNode node1=list1.pop();
            ListNode cur=new ListNode((node1.val+tmp)%10);
            tmp=(node1.val+tmp)/10;
            cur.next=pre;
            pre=cur;
        }
        while (!list2.isEmpty()){
            ListNode node2=list2.pop();
            ListNode cur=new ListNode((node2.val+tmp)%10);
            tmp=(node2.val+tmp)/10;
            cur.next=pre;
            pre=cur;
        }
        if(tmp!=0){
            ListNode cur=new ListNode(tmp);
            cur.next=pre;
            pre=cur;
        }
        return pre;


    }


    public static void main(String[] args) {
        System.out.println(1/10);
        System.out.println(11/10);
    }
}

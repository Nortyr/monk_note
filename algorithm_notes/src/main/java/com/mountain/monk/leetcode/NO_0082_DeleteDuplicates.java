package com.mountain.monk.leetcode;

public class NO_0082_DeleteDuplicates {

    /**
     * 注意，删掉链表节点后，cur不需要移动到下一位
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode temp=new ListNode(-1);
        temp.next=head;
        ListNode cur=temp;
        while(cur.next!=null){
            ListNode next1=cur.next;
            ListNode next2=cur.next.next;
            if(next2!=null&&next2.val==next1.val){
                while (next2!=null&&next2.val==next1.val){
                    next1=next2;
                    next2=next2.next;
                }
                cur.next=next2;
            }else{
                cur=cur.next;
            }
        }
        return head.next;
    }


    public static void main(String[] args) {
        System.out.println(3/2);
        ListNode node4=new ListNode(4,null);
        ListNode node44=new ListNode(4,node4);

        ListNode node3=new ListNode(3,node44);
        ListNode node33=new ListNode(3,node3);

        ListNode node2=new ListNode(2,node33);

        ListNode node1=new ListNode(1,node2);
        new NO_0082_DeleteDuplicates().deleteDuplicates(node1);

    }
}

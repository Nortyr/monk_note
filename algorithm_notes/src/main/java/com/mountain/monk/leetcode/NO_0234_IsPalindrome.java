package com.mountain.monk.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NO_0234_IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if(head==null) return true;
        List<Integer> list=new ArrayList<>();
        ListNode cur=head;
        while(cur!=null){
            list.add(cur.val);
            cur=cur.next;
        }

        int left=0,right=list.size()-1;
        while(left<right){
            if(list.get(left)!=list.get(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;

    }
}

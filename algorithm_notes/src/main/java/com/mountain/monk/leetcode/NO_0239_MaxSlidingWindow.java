package com.mountain.monk.leetcode;

import java.util.LinkedList;

public class NO_0239_MaxSlidingWindow {
    /**
     * link:https://leetcode.cn/problems/sliding-window-maximum/
     * 思路，单调栈，
     * 栈底大
     * 栈顶小
     *
     * 栈底老
     * 栈顶新
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> list=new LinkedList<>();
        for (int i = 0; i < k; i++) {

            while (!list.isEmpty()&&nums[list.peek()]<=nums[i]){
                list.pop();
            }
            list.push(i);
        }
        int [] ans=new int[nums.length-k+1];
        for (int i = k; i < nums.length; i++) {
            ans[i-k]=nums[list.peekLast()];
            if(list.peekLast()<=i-k){
                list.pollLast();
            }

            while (!list.isEmpty()&&nums[list.peek()]<=nums[i]){
                list.pop();
            }
            list.push(i);
        }
        ans[ans.length-1]=nums[list.peekLast()];



        return ans;


    }

    public static void main(String[] args) {
        new NO_0239_MaxSlidingWindow().maxSlidingWindow(new int[]{7,2,4},2);
    }
}

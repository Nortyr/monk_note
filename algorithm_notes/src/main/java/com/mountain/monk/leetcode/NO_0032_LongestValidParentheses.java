package com.mountain.monk.leetcode;

import java.util.LinkedList;

public class NO_0032_LongestValidParentheses {
    /**
     * link:https://leetcode.cn/problems/longest-valid-parentheses/submissions/494980241/
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        LinkedList<Integer> list=new LinkedList<>();
        char[] arr=s.toCharArray();
        int maxLen=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]=='('){
                list.push(i);
            }else{
                if(list.isEmpty()){
                    list.push(i);
                }else if(arr[list.peek()]=='('){
                    list.pop();
                    maxLen=Math.max(maxLen,list.isEmpty()?i-0+1:i-list.peek());
                }else{
                    list.push(i);
                }

            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        new NO_0032_LongestValidParentheses().longestValidParentheses("(()))())(");
    }
}

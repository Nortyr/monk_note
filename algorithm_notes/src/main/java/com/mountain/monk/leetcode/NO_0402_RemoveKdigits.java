package com.mountain.monk.leetcode;

import java.util.LinkedList;
import java.util.Stack;

public class NO_0402_RemoveKdigits {
    public String removeKdigits(String num, int k) {
        if(num.length()<=k){
            return "0";
        }

        int count=0;
        LinkedList<Character> stack=new LinkedList<>();
        for (char c:num.toCharArray()){
            while (count<k&&!stack.isEmpty()&&stack.peek()>c){
                stack.pop();
                count++;
            }
            if(c!='0'||!stack.isEmpty()){
                stack.push(c);
            }
        }
        while (count<k&&!stack.isEmpty()){
            stack.pop();
            count++;
        }
        if(stack.isEmpty()){
            return "0";
        }
        StringBuilder sb=new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pollLast());
        }
        return sb.toString();


    }
}

package com.mountain.monk.leetcode;

import java.util.Stack;

public class NO_0739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack=new Stack<>();
        int [] result=new int[temperatures.length];
        for (int i = temperatures.length-1; i >=0 ; i--) {
            while (!stack.isEmpty()&&temperatures[stack.peek()]<=temperatures[i]){
                stack.pop();
            }
            result[i]=stack.isEmpty()?0:stack.peek()-i;
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        new NO_0739_DailyTemperatures().dailyTemperatures(new int[]{89,62,70,58,47,47,46,76,100,70});
    }
}

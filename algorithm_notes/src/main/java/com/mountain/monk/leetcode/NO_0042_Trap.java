package com.mountain.monk.leetcode;

import java.util.LinkedList;

public class NO_0042_Trap {
    public int trap(int[] height) {
        int ans = 0;
        //单调栈从大到小
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < height.length; i++) {
            //按层计算水
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty() ) {
                    break;
                }
                int left =stack.peek();
                int curWidth = i-left-1;
                int curHeight = Math.min(height[left],height[i])-height[top];
                ans+=curWidth*curHeight;

            }
            stack.push(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        new NO_0042_Trap().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}

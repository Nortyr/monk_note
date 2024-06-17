package com.mountain.monk.leetcode;

import java.util.LinkedList;

public class NO_0011_MaxArea {


    /**
     * 双指针
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int l=0,r=height.length,result=0;
        while(l<r){
            int h=Math.min(height[l],height[r]);
            result=Math.max(result,h*(r-l));
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return result;
    }
    /**
     * 单调栈不行，121,处理不了
     * @param height
     * @return
     */
    public int maxArea1111(int[] height) {
        LinkedList<Integer> stack=new LinkedList<>();
        int result=0;
        for (int i = 0; i < height.length; i++) {
            while(!stack.isEmpty()&&height[stack.peek()]<height[i]){
                stack.pop();
            }
            stack.push(i);
            result=Math.max(result,height[i]*(i-stack.peekLast()));
        }
        return result;
    }
}

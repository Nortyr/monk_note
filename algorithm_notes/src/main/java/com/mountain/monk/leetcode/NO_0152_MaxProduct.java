package com.mountain.monk.leetcode;

public class NO_0152_MaxProduct {
    public int maxProduct(int[] nums) {
        int[] minArray=new int[nums.length];
        int[] maxArray=new int[nums.length];
        minArray[0]=nums[0];
        maxArray[0]=nums[0];
        int result=Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            minArray[i]=Math.min(nums[i],Math.min(minArray[i-1]*nums[i],maxArray[i-1]*nums[i]));
            maxArray[i]=Math.max(nums[i],Math.max(minArray[i-1]*nums[i],maxArray[i-1]*nums[i]));
            result=Math.max(maxArray[i],result);
        }
        return result;
    }
}

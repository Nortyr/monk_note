package com.mountain.monk.leetcode;

public class NO_0045_Jump {

    public int jump(int[] nums) {
        int max=0;
        int result=0;
        int end=0;
        int steps=0;
        for (int i = 0; i < nums.length; i++) {
            max=Math.max(nums[i]+i,max);
            //维护右边界
            if (i == end) {
                end = max;
                steps++;
            }


        }
        return steps;
    }
}

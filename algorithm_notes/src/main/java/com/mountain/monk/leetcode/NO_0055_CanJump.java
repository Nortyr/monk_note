package com.mountain.monk.leetcode;

public class NO_0055_CanJump {
    public boolean canJump(int[] nums) {
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            if(max>=i||i==0){
                max=Math.max(i+nums[i],max);
            }else {
                break;
            }
        }
        return max>=nums.length;
    }
}

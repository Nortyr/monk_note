package com.mountain.monk.leetcode;

public class NO_0136_SingleNumber {
    public int singleNumber(int[] nums) {
        int num=0;
        for(int i=0;i<nums.length;i++){
            num^=nums[i];
        }
        return num;
    }
}

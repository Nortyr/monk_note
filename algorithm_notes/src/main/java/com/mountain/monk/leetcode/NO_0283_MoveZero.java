package com.mountain.monk.leetcode;

public class NO_0283_MoveZero {
    public void moveZeroes(int[] nums) {
        int n=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                nums[n++]=nums[i];
            }
        }
        while (n<nums.length){
            nums[n++]=0;
        }

    }
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

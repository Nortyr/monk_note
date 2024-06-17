package com.mountain.monk.leetcode;

public class NO_0026_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int l=0,r=1,result=0;
        while(r<nums.length){

            if(nums[l]<nums[r]){
                nums[++l]=nums[r];
                result++;
            }else{
                r++;
            }

        }
        return result+1;
    }
}

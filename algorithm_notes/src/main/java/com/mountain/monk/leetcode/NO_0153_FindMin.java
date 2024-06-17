package com.mountain.monk.leetcode;

public class NO_0153_FindMin {
    public int findMin(int[] nums) {
        int l=0,r=nums.length-1,middle=(l+r)/2;
        while(l<r){
            middle=(l+r)/2;
            if (nums[middle] < nums[r]) {
                r = middle;
            }
            else {
                l = middle + 1;
            }


        }
        return  r;
    }
}

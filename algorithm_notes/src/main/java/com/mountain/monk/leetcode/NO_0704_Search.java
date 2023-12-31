package com.mountain.monk.leetcode;

public class NO_0704_Search {

    /**
     * link:https://leetcode.cn/problems/binary-search/
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        return process(nums,target,0,nums.length-1);
    }

    public int process(int[] nums, int target,int left,int right){
        if(left>right) {
            return -1;
        }

        int mid=(left+right)/2;
        if(nums[mid]==target){
            return mid;
        } else if (nums[mid]>target) {
            return process(nums,target,left,mid-1);
        }else{
            return process(nums,target,mid+1,right);
        }
    }
}

package com.mountain.monk.leetcode;

public class NO_0075_sortColors {
    /**
     * 荷兰国旗问题
     * @param nums
     */
    public void sortColors(int[] nums) {
        int temp=1;
        int l=-1,r=nums.length;
        int cur=0;
        while (cur<r){
            if(nums[cur]<temp){
                swap(nums,++l,cur++);
            } else if(nums[cur]>temp){
                swap(nums,--r,cur);
            }else{
                cur++;
            }
        }

    }


    void swap(int []nums,int l,int r){
        int tmp=nums[l];
        nums[l]=nums[r];
        nums[r]=tmp;
    }
}

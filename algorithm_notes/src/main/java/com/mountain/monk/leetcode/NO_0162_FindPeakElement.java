package com.mountain.monk.leetcode;

public class NO_0162_FindPeakElement {
    /**
     * 中间数和右边第一个数比大小
     * 比较倾斜
     * / 这样子，极大值在右侧
     * \ 这样子，极大值在左侧
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=(left+right)/2;

            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

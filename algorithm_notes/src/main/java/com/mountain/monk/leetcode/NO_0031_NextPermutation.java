package com.mountain.monk.leetcode;

import java.util.Arrays;

public class NO_0031_NextPermutation {

    /**
     * 从后往前找，找到第一个降的
     * 再从后往前找，因为从后往前是升序，不会打破顺序结构，找到比当前数大的交换
     * 注意！！！ 不需要考虑等于情况
     * i+1位置从左往右是降序，直接头尾交换即可
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int pre=nums[nums.length-1];
        int i = nums.length-2;
        for (; i >=0 ; i--) {
            if(nums[i]<pre){
                break;
            }
            pre=nums[i];
        }
        if(i<0){
            Arrays.sort(nums);
            return ;
        }
        int min=nums[i];
        int j = nums.length-1;
        for (; j >i; j--) {
            if(nums[j]>nums[i]){
                break;
            }
        }
        swap(nums,i,j);
        reverse(nums,i+1);
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }



    private void swap(int[] nums, int i, int i1) {
        int tmp=nums[i];
        nums[i]=nums[i1];
        nums[i1]=tmp;
    }

    public static void main(String[] args) {
        new NO_0031_NextPermutation().nextPermutation(new int[]{1,5,1});
    }

}

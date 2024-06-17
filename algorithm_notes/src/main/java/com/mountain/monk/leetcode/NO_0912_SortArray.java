package com.mountain.monk.leetcode;

public class NO_0912_SortArray {


    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums, int L, int R) {
        if(L>=R) return;
        int l=L;
        int r=R;
        int temp=nums[l+ (int) (Math.random() * (r - l + 1))];
        int[] resultArr=partition(nums,l,r,temp);
        quickSort(nums,L,resultArr[0]-1);
        quickSort(nums,resultArr[1]+1,R);



    }

    int [] partition(int []nums,int l,int r,int temp){
        int less=l-1;
        int more=r+1;
        int cur=l;
        while (cur<more){
            if(nums[cur]<temp){
                swap(nums,++less,cur++);
            }else if(nums[cur]>temp){
                swap(nums,cur,--more);
            }else{
                cur++;
            }
        }
        return new int[]{less+1,more-1};
    }

    private void swap(int []nums,int l,int r){
        int temp=nums[l];
        nums[l]=nums[r];
        nums[r]=temp;
    }
}

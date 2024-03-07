package com.mountain.monk.leetcode;

public class NO_0209_MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int result=Integer.MAX_VALUE;
        int[] sumArr=new int[nums.length+1];
        int sum=0;
        sumArr[0]=0;
        int left=0,right=0;
        for (int i = 0; i < nums.length; i++) {
            sum+= nums[i];
            sumArr[i+1]=sum;
            if(sum>=target&&result==Integer.MAX_VALUE){
                right=i;
                result=i;
            }
        }
        while(right<sumArr.length-1&&right>=left){
            if(sumArr[right]-sumArr[left]>=target){
                result=Math.min(result,right-left);
                left++;
            }else{
                right++;
            }
        }

        while(right>=left){
            if(sumArr[right]-sumArr[left]>=target) {
                result = Math.min(result, right - left);
            }
                left++;

        }

        return result;



    }

    private static int preSum(int target, int[] nums) {
        int result=Integer.MAX_VALUE;
        int[] sumArr=new int[nums.length+1];
        int sum=0;
        sumArr[0]=0;
        for (int i = 0; i < nums.length; i++) {
            sum+= nums[i];
            sumArr[i+1]=sum;
        }

        for (int i = 0; i <sumArr.length ; i++) {

            for (int j = i; j < sumArr.length; j++) {
                if(sumArr[j]-sumArr[i]>= target){
                    result=Math.min(result,j-i);
                    break;
                }
            }
        }
        return Integer.MAX_VALUE == result ? 0 : result;
    }
}

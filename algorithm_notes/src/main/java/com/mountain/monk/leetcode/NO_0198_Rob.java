package com.mountain.monk.leetcode;

public class NO_0198_Rob {

    private int max;
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int dp[]=new int[nums.length+1];
        dp[0]=0;
        dp[1]=nums[0];
        for (int i = 2; i < dp.length; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[nums.length];

    }
    //超时
    private int extracted(int[] nums) {
        process(nums,0,true,0);
        process(nums,0,false,0);
        return max;
    }

    private void process(int[] nums, int i, boolean b, int sum) {
        if(i>=nums.length){
            max=Math.max(sum,max);
            return ;
        }
        if(b){
            process(nums,i+2,true,sum+nums[i]);
            process(nums,i+2,false,sum+nums[i]);
        }else{
            process(nums,i+1,true,sum);
            process(nums,i+1,false,sum);


        }
    }

}

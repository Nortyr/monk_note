package com.mountain.monk.leetcode;

public class NO_0322_CoinChange {


    public int coinChange3(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }

        int[] dp=new int[amount+1];

        dp[0]=0;


        return process2(coins,amount,dp);
    }


    /**
     * 方案二：记忆化搜索
     *
     * 原来硬币建队列，比最小值没有必要，直接按金额建立最小值即可，
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }

        int[] dp=new int[amount+1];



        return process2(coins,amount,dp);
    }


    public int process2(int []coins,int left,int []dp){
        if(left<0){
            return -1;
        }
        else if (left==0) {
            return 0;
        }

        if(dp[left]!=0){
            return dp[left]==-1?-1:dp[left]+1;
        }

        int min=Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int count=process2(coins,left-coins[i],dp);


            if(count!=-1){
                min=Math.min(count,min);
            }
        }
        if(min==Integer.MAX_VALUE){
            dp[left]=-1;
            return -1;
        }else{
            dp[left]=min;

            return min+1;
        }

    }

    /**
     * 递归写法
     * @param coins
     * @param left
     * @return
     */

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }

        return process(coins,amount);
    }



    public int process(int []coins,int left){
        if(left<0){
            return -1;
        }
        else if (left==0) {
            return 0;
        }
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int count=process(coins,left-coins[i]);
            if(count!=-1){
                min=Math.min(count,min);
            }
        }

        if(min==Integer.MAX_VALUE){
            return -1;
        }else{
            return min+1;
        }

    }





}

package com.mountain.monk.leetcode;

public class NO_0122_MaxProfit {
    int result=0;
    public int maxProfit(int[] prices) {
        int dp[][]=new int[2][prices.length];
        dp[0][0]=0;
        dp[1][0]=-prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[0][i]=Math.max(dp[1][i-1]+prices[i],dp[0][i-1]);
            dp[1][i]=Math.max(dp[1][i-1],dp[0][i-1]-prices[i]);
        }
//        process(prices,0,false,0,dp);
        return dp[0][prices.length-1];
    }

    private int  process(int[] prices, int cur, boolean b,int sum,int dp[][]) {
        if(cur>=prices.length){
            return sum;
        }


        if(b){
            if(dp[0][cur]!=0){
                return dp[0][cur];
            }

            //不卖
            int x= process(prices,cur+1,true,sum,dp);
            //卖
            int x2=process(prices,cur+1,false,sum+prices[cur],dp);
            dp[0][cur]=Math.max(x,x2);
            return dp[0][cur];
        }else{
            if(dp[1][cur]!=0){
                return dp[1][cur];
            }
            //不买
            int x=process(prices,cur+1,false,sum,dp);
            //买
            int x2=process(prices,cur+1,true,sum-prices[cur],dp);
            dp[1][cur]=Math.max(x,x2);
            return dp[1][cur];

        }
    }

    public static void main(String[] args) {
        new NO_0122_MaxProfit().maxProfit(new int[]{7,1,5,3,6,4});
    }

    //穿透递归
//    int result=0;
//    public int maxProfit(int[] prices) {
//        process(prices,0,false,0);
//        return result;
//    }
//
//    private void process(int[] prices, int cur, boolean b,int sum) {
//        if(cur>=prices.length){
//            result=Math.max(result,sum);
//            return;
//        }
//
//
//        if(b){
//            //不卖
//            process(prices,cur+1,true,sum);
//            //卖
//            process(prices,cur+1,false,sum+prices[cur]);
//        }else{
//            //不买
//            process(prices,cur+1,false,sum);
//            //买
//            process(prices,cur+1,true,sum-prices[cur]);
//        }
//    }
}

package com.mountain.monk.leetcode;

public class NO_0221_MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int [][]dp=new int[matrix.length][matrix[0].length];
        int max=0;
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0]=matrix[i][0]-'0';
            max=Math.max(max,dp[i][0]);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i]=matrix[0][i]-'0';
            max=Math.max(max,dp[0][i]);

        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length ; j++) {
                if(matrix[i][j]=='0'){
                    dp[i][j]=0;
                }else{
                    dp[i][j]=Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]))+1;
                }
                max=Math.max(max,dp[i][j]);


            }
        }
        return max*max;



    }
// 1 1 0 1 0
// 1 1 1 1 0
// 0 1 1 1 1
// 1 1 1 1 1
// 0 0 1 1 1


}

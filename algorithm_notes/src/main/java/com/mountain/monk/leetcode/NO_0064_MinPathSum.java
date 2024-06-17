package com.mountain.monk.leetcode;

public class NO_0064_MinPathSum {
    int min=Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        //递归
        //process(grid,0,0,0);
        //return min;

        int[][] dp=new int[grid.length][grid[0].length];
        int sum=0;
        for (int i = 0; i < grid.length; i++) {
            sum+=grid[i][0];
            dp[i][0]=sum;
        }
        sum=0;
        for (int i = 0; i < grid[0].length; i++) {
            sum+=grid[0][i];
            dp[0][i]=sum;
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[dp.length-1][dp[0].length-1];


    }






    private void process(int[][] grid, int x, int y, int sum) {
        if(x>=grid.length||y>=grid[0].length){
            return;
        }
        if(x==grid.length-1&&y==grid[0].length-1){
            min=Math.min(min,sum+grid[grid.length-1][grid[0].length-1]);
        }

        process(grid, x+1, y, sum+grid[x][y]);
        process(grid, x, y+1, sum+grid[x][y]);


    }
}

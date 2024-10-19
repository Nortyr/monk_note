package com.mountain.monk.leetcode;

public class NO_0200_numIslands {
    int result=0;
    public int numIslands(char[][] grid) {


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    process(grid,i,j);
                }
            }
        }

        return result;



    }

    private void process(char[][] grid, int i, int j) {
        if(i<0||j<0||i>=grid.length||j>=grid[i].length||grid[i][j]=='0'){
            return ;
        }

        grid[i][j]='0';
        process(grid,i-1,j);
        process(grid,i,j-1);
        process(grid,i+1,j);
        process(grid,i,j+1);
    }
}

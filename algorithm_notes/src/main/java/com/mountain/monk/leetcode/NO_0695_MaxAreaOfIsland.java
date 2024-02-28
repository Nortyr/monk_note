package com.mountain.monk.leetcode;

public class NO_0695_MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1){

                    int result= process(grid,i,j);
                    max=Math.max(result,max);
                }
            }
        }
        return max;

    }

    public int process (int[][] grid,int x,int y){
        if(x>=grid.length||y>=grid[0].length||x<0||y<0){
            return 0;
        }
        if(grid[x][y]==0||grid[x][y]==2){
            return 0;
        }
        grid[x][y]=2;
        ;
        return process(grid,x-1,y)+process(grid,x+1,y)+process(grid,x,y+1)+process(grid,x,y-1)+1;


    }
}

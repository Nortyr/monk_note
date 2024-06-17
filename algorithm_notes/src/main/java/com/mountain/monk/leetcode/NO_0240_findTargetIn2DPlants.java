package com.mountain.monk.leetcode;

public class NO_0240_findTargetIn2DPlants {
    /**
     * 坐下角看，整个矩阵是二叉树
     * @param plants
     * @param target
     * @return
     */
    public boolean findTargetIn2DPlants(int[][] plants, int target) {
        int x=plants.length-1,y=0;

        while (x>=0&&y< plants[0].length){
            if(plants[x][y]==target){
                return true;
            }
            else if(plants[x][y]>target){
                x--;
            }else{
                y++;
            }

        }
        return false;
    }
}

package com.mountain.monk.leetcode;

public class NO_0498_FindDiagonalOrder {
    /*****
     *   0 1 2 3
     * 0
     * 1
     * 2
     * 3
     * x竖轴
     * y横轴
     * @param mat
     * @return
     */
    public int[] findDiagonalOrder(int[][] mat) {
        int x=mat.length;
        int y=mat[0].length;
        int count=0;
        int [] result=new int[x*y];
        for (int i = 0; i <x+y-1 ; i++) {
            boolean up=(i&1)==0;
            if(up){
                int x1=Math.min(i,x-1);
                int y1=i-x1;
                while(y1<y&&x1>=0){
                    result[count++]=mat[x1][y1];
                    x1--;
                    y1++;
                }
            }else{
                int y1=Math.min(i,y-1);
                int x1=i-y1;
                while (y1>=0&&x1<x){
                    result[count++]=mat[x1][y1];
                    x1++;
                    y1--;
                }
            }
        }
        return result;
    }

}

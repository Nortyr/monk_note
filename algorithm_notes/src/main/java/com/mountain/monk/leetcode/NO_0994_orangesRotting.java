package com.mountain.monk.leetcode;

import java.util.LinkedList;

public class NO_0994_orangesRotting {

    int origin=0;
    public int orangesRotting(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;


        int counts=0;
        LinkedList<int []> queue = new LinkedList<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == 1){
                    origin++;
                }else if (grid[i][j] == 2) {
                    queue.addLast(new int[]{i, j});
                }
            }
        }


        while (origin>0&&!queue.isEmpty()) {

            counts++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] arr=queue.removeFirst();
                process(grid,queue,arr[0]+1,arr[1]);
                process(grid,queue,arr[0],arr[1]+1);
                process(grid,queue,arr[0]-1,arr[1]);
                process(grid,queue,arr[0],arr[1]-1);
            }

        }




        return origin==0?counts:-1;
    }

    private void process(int[][] grid, LinkedList<int[]> queue, int x, int y) {
        if(x<0||y<0||x>=grid.length||y>=grid[0].length){
            return;
        }
        if(grid[x][y]==1){
            queue.addLast(new int[]{x,y});
            origin--;
            grid[x][y]=2;
        }
    }

}

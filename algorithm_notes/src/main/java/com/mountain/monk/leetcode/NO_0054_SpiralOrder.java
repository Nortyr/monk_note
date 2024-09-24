package com.mountain.monk.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NO_0054_SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int x1=0,y1=0,x2=matrix.length-1,y2=matrix[0].length-1;
        while (x1<=x2 && y1<=y2) {
            for (int i = y1; i <= y2; i++) {
                ans.add(matrix[x1][i]);
            }

            for (int i = x1+1; i <= x2; i++) {
                ans.add(matrix[i][y2]);
            }
            for (int i = y2-1; i >= y1&&x1!=x2; i--) {
                ans.add(matrix[x2][i]);
            }
            for (int i = x2-1; i >=x1+1&&y1!=y2; i--) {
                ans.add(matrix[i][y1]);
            }

            x1++;
            y1++;
            y2--;
            x2--;
        }
        return ans;
    }

    public static void main(String[] args) {
        new NO_0054_SpiralOrder().spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
    }
}

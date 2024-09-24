package com.mountain.monk.leetcode;

public class NO_0048_Rotate {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int [][] result=new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[j][n - i - 1] = matrix[i][j];
            }
        }
        matrix=result;
    }
}

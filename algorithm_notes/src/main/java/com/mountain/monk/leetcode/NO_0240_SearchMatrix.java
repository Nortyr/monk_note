package com.mountain.monk.leetcode;

public class NO_0240_SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        int col= matrix[0].length;
        int startRow=0;
        int startCol=col-1;
        while (startCol>=0&&startRow<row){
            if(matrix[startRow][startCol]>target){
                startCol--;
            } else if (matrix[startRow][startCol]<target) {
                startRow++;
            }else{
                return true;
            }
        }
        return false;
    }
}

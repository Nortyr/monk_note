package com.mountain.monk.leetcode;

public class NO_0059_generateMatrix {
    public int[][] generateMatrix(int n) {
        int [][] result=new int[n][n];
        int left=0,rigth=n-1,top=0,buttom=n-1;
        int start=1,end=n*n;
        while (start<=end){
            for (int i = left; i <=rigth; i++) {
                result[top][i]=start++;
            }

            for (int i = top+1; i <= buttom; i++) {
                result[i][rigth]=start++;
            }
            for (int i = rigth-1; i >= left; i--) {
                result[buttom][i]=start++;
            }
            for (int i = buttom-1; i >= top+1; i--) {
                result[i][left]=start++;
            }
            left++;
            rigth--;
            top++;
            buttom--;

        }
        return result;
    }

    public static void main(String[] args) {
        new NO_0059_generateMatrix().generateMatrix(3);
    }
}

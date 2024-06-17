package com.mountain.monk.leetcode;

public class NO_0079_Exist {

    public boolean exist(char[][] board, String word) {
        char[] charArray=word.toCharArray();
        int x=board.length;
        int y=board[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(process(board,charArray,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean process(char[][] board, char[] charArray, int i, int j, int len) {
        if(charArray.length==len){
            return true;
        }
        if (i >= board.length || j >board[0].length||i<0||j<0){
            return false;
        }
        if(board[i][j]!=charArray[len]){
            return false;
        }
        char tmp=board[i][j];
        board[i][j]=0;
        boolean flag=process(board,charArray,i+1,j,len)||
                process(board,charArray,i,j+1,len)||
                process(board,charArray,i-1,j,len)||
                process(board,charArray,i,j-1,len);
        board[i][j]=tmp;
        return flag;
    }
}

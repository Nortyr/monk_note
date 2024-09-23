package com.mountain.monk.leetcode;

import java.util.HashSet;
import java.util.Set;

public class NO_0073_SetZeroes {
    public void setZeroes(int[][] matrix) {
        Set<Integer> xset =new HashSet<>();
        Set<Integer> yset =new HashSet<>();

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    xset.add(i);
                    yset.add(j);
                }
            }
        }
        if(!xset.isEmpty()){
            xset.forEach(x->{
                for(int j=0;j<matrix[0].length;j++){
                    matrix[x][j]=0;
                }
            });
        }
        if(!yset.isEmpty()){
            yset.forEach(x->{
                for(int j=0;j<matrix.length;j++){
                    matrix[j][x]=0;
                }
            });
        }
    }
}

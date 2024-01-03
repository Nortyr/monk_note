package com.mountain.monk.leetcode;

public class NO_0062_UniquePaths {
    public int uniquePaths(int m, int n) {

        return process(m-1,n-1,0,0);
    }



    public int process(int m,int n,int x,int y){
        if(x>m||y>n){
            return 0;
        } else if (x==m&&y==n) {
            return 1;
        }

        return process(m,n,x+1,y)+process(m,n,x,y+1);

    }
}

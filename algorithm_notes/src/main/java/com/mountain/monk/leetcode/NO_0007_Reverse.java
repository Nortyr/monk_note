package com.mountain.monk.leetcode;

public class NO_0007_Reverse {


    public int reverse(int x) {
        boolean flag=false;
        if(x<0){
            flag=true;
            x=-x;
        }
        int n=0;
        while(x>0){
            if (n < Integer.MIN_VALUE / 10 || n > Integer.MAX_VALUE / 10) {
                return 0;
            }


            n=n*10+x%10;
            x=x/10;
        }
        return flag?-n:n;
    }

    public static void main(String[] args) {
        new NO_0007_Reverse().reverse(1534236469);
    }

}

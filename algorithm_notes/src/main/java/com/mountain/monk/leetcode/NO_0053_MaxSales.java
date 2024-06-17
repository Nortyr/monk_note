package com.mountain.monk.leetcode;

public class NO_0053_MaxSales {
    public int maxSales(int[] sales) {
        int result1=sales[0];

        int result=sales[0];
        for (int i = 1; i < sales.length; i++) {
            result=Math.max(sales[i],result+sales[i]);
            result1=Math.max(result,result1);
        }
        return result1;
    }

    public static void main(String[] args) {
        new NO_0053_MaxSales().maxSales(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}

package com.mountain.monk.leetcode;

public class NO_0718_FindLength {
    public int findLength(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int result=Integer.MIN_VALUE;
        int dp[][]=new int[n+1][m+1];
        for (int i = 0; i < n; i++) {
            if(nums1[i]==nums2[0]){
                dp[i][0]=1;
                result=1;
            }
        }
        for (int i = 0; i < m; i++) {
            if(nums1[0]==nums2[i]){
                dp[0][i]=1;
                result=1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(nums1[i]==nums2[j]){
                    dp[i][j]=dp[i-1][j-1]+1;
                    result=Math.max(dp[i][j],result);
                }
            }
        }
        return result;

    }
}

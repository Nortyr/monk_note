package com.mountain.monk.leetcode;

public class NO_1143_LongestCommonSubsequence {
    /**
     * link:https://leetcode.cn/problems/longest-common-subsequence/
     * 解法：动态规划
     * 思路：dp[i][j]
     * i:text1以i结尾字符串
     * j:text2以j结尾字符串
     * dp[i][j]以ij结尾的最长公共子串
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        if(n*m==0){
            return 0;
        }

        int dp[][] =new int[n+1][m+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                int x=dp[i-1][j];
                int y=dp[i][j-1];
                int z=dp[i-1][j-1];
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    z++;
                }
                dp[i][j]=Math.max(x,Math.max(y,z));
            }
        }
        return dp[n][m];
    }
}

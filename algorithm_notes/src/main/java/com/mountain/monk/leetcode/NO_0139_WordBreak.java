package com.mountain.monk.leetcode;

import java.util.Arrays;
import java.util.List;

public class NO_0139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int dp[] =new int[s.length()+1];
        dp[s.length()]=1;
        for (int i = s.length()-1; i >=0 ; i--) {
            int ways=0;
            for (int j = i ; j < s.length(); j++) {
                String sub=s.substring(i,j+1);
                if(wordDict.contains(sub)){
                    ways+=dp[j+1];
                    dp[i]=ways;
                }
            }
        }
        return dp[0]!=0;
    }


    public static void main(String[] args) {
        new NO_0139_WordBreak().wordBreak("leetcode", Arrays.asList("leet","code"));
    }
}

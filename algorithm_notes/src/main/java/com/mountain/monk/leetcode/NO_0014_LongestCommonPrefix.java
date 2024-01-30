package com.mountain.monk.leetcode;

public class NO_0014_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            min=Math.min(min,strs[i].length());
        }
        int i=0;
        for (; i < min; i++) {
            char target=strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(strs[j].charAt(i)!=target){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0].substring(0,min);
    }

    public static void main(String[] args) {
        new NO_0014_LongestCommonPrefix().longestCommonPrefix(new String[]{"ab","a"});
    }
}

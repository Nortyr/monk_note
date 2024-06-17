package com.mountain.monk.leetcode;

public class NO_0125_isPalindrome {

    public boolean isPalindrome(String s) {
        StringBuilder sb=new StringBuilder();
        for (char c : s.toCharArray()) {
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }
}

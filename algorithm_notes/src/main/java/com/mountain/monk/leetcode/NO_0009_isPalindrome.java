package com.mountain.monk.leetcode;

public class NO_0009_isPalindrome {
    public boolean isPalindrome(int x) {

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int cur = 0;
        int num = x;

        while(cur < num) {
            cur=cur*10+num%10;
            num=num/10;

        }
        return cur == num || cur / 10 == num;
    }

    public static void main(String[] args) {
        new NO_0009_isPalindrome().isPalindrome(121);
    }

    /**
     * 字符串比较
     * @param x
     * @return
     */
    private static boolean plan1(int x) {
        StringBuilder sb=new StringBuilder(String.valueOf(x));
        return sb.toString().equals(sb.reverse().toString());
    }
}

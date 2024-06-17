package com.mountain.monk.leetcode;

import java.util.Arrays;

public class NO_0179_LargestNumber {

    public String largestNumber(int[] nums) {
        String[] strs=new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(strs,(x,y)->(y+x).compareTo(x+y));
        StringBuilder sb=new StringBuilder();
        for (String s:strs){
            sb.append(s);
        }
        return sb.toString();
    }

}

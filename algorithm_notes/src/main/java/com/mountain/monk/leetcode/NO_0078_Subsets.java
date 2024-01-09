package com.mountain.monk.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NO_0078_Subsets {
    /**
     * link:https://leetcode.cn/problems/subsets/description/
     * 思虑
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result=new ArrayList<>();
        result.add(new ArrayList<>());
        List<Integer> list=new ArrayList<>();
        process(nums,0,result,list);
        return result;
    }

    private void process(int[] nums, int i, List<List<Integer>> result, List<Integer> list) {
        if(i>=nums.length){
            return;
        }


        for (int j = i; j < nums.length; j++) {
            list.add(nums[j]);
            process(nums,j+1,result,list);
            result.add(new ArrayList<>(list));
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res=new NO_0078_Subsets().subsets(new int[]{1,2,3});
        System.out.println(res);
    }
}

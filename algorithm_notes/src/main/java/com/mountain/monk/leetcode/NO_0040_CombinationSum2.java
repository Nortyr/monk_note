package com.mountain.monk.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NO_0040_CombinationSum2 {

    private List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        process(candidates,target,0,0,new ArrayList<>());


        return result;

    }

    private void process(int[] candidates, int target, int start, int sum, ArrayList<Integer> combination) {


        if(sum==target){
            result.add(new ArrayList<>(combination));
            return ;
        }
        if (sum > target || start >= candidates.length) {
            return;
        }

//        combination.add(candidates[start]);
//        process(candidates,target,start+1,sum+candidates[start],combination);
//        combination.remove(combination.size()-1);

        for (int i = start; i < candidates.length; i++) {
            // 跳过重复元素
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            combination.add(candidates[i]);
            process(candidates, target, i + 1, sum + candidates[i], combination);
            combination.remove(combination.size() - 1);
        }

    }



//    private void process(int[] candidates, int target, int start, int sum, ArrayList<Integer> combination) {
//        if (sum == target) {
//            result.add(new ArrayList<>(combination));
//            return;
//        }
//        if (sum > target || start >= candidates.length) {
//            return;
//        }
//
//        for (int i = start; i < candidates.length; i++) {
//            // 跳过重复元素
//            if (i > start && candidates[i] == candidates[i - 1]) {
//                continue;
//            }
//            combination.add(candidates[i]);
//            process(candidates, target, i + 1, sum + candidates[i], combination);
//            combination.remove(combination.size() - 1);
//        }
//    }
}

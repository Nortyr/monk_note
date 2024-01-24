package com.mountain.monk.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NO_0039_CombinationSum {
    List<List<Integer>> list=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        process(candidates,target,new ArrayList<>(),0,0);
        return list;
    }

    private void process(int[] candidates, int target, ArrayList<Integer> objects, int sum,int start) {
        if(sum>target){
            return;
        }else if(sum==target){
            list.add(new ArrayList<>(objects));
        }

        for (int i = start; i < candidates.length; i++) {
            objects.add(candidates[i]);
            process(candidates,target,objects,sum+candidates[i],i);
            objects.remove(objects.size()-1);

        }


    }
}

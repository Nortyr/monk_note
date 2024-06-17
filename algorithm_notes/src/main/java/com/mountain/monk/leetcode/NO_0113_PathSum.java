package com.mountain.monk.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NO_0113_PathSum {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root,int targetSum) {
        process(root,targetSum,new ArrayList<>(),0);
        return result;
    }

    private void process(TreeNode root, int targetSum,List<Integer> list, int sum) {
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            if(sum+root.val==targetSum){
                list.add(root.val);
                result.add(new ArrayList<>(list));
                list.remove(list.size()-1);

                return;
            }
        }

        list.add(root.val);
        process(root.left,targetSum,list,sum+ root.val);
        process(root.right,targetSum,list,sum+ root.val);


        list.remove(list.size()-1);

    }
}

package com.mountain.monk.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NO_0144_PreorderTraversal {

    private List<Integer> list=new ArrayList();
    public List<Integer> preorderTraversal(TreeNode root) {
        process(root);
        return list;
    }



    public void  process(TreeNode root) {
        if(root==null) return ;
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);

    }
}

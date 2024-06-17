package com.mountain.monk.leetcode;

public class NO_0104_MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;

        return process(root);
    }

    private int process(TreeNode root) {
        if(root==null) return 0;

        return Math.max(process(root.left),process(root.right))+1;


    }



}

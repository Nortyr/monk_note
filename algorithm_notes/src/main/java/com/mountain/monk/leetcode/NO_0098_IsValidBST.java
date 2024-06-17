package com.mountain.monk.leetcode;

public class NO_0098_IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return process(root,Long.MIN_VALUE,Long.MIN_VALUE);
    }

    private boolean process(TreeNode root,long lower,long upper) {
        if(root==null){
            return true;
        }
        if(root.val<=lower||root.val>=upper){
            return false;
        }


        return process(root.left,lower,root.val)&&process(root.right,root.val,upper);
    }
}


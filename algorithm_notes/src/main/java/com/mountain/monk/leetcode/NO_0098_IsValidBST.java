package com.mountain.monk.leetcode;

public class NO_0098_IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return process(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean process(TreeNode root, long min, long max) {
        if(root == null) {
            return true;
        }
        if(root.val >= max || root.val <= min) {
            return false;
        }
        return process(root.left, min, root.val) && process(root.right, root.val, max);
    }


}


package com.mountain.monk.leetcode;

public class NO_0543_DiameterOfBinaryTree {

    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        process(root);
        return max;
    }

    public int process(TreeNode root) {
        if(root==null){
            return 0;
        }

        int left=process(root.left);
        int right=process(root.right);
        max=Math.max(max,left+right);
        return Math.max(left,right)+1;
    }
}

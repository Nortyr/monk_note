package com.mountain.monk.leetcode;

public class NO_0110_IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int left=process(root.left);
        int right=process(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public int process(TreeNode node){
        if(node==null){
            return 0;
        }

        return Math.max(process(node.right),process(node.left))+1;

    }
}

package com.mountain.monk.leetcode;

public class NO_0226_InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return root;
        reverseTree(root);
        return root;
    }

    private void reverseTree(TreeNode root) {
        if (root==null) return;
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        reverseTree(root.right);
        reverseTree(root.left);
    }
}

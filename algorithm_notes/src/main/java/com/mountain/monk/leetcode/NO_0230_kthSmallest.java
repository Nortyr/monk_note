package com.mountain.monk.leetcode;

public class NO_0230_kthSmallest {
    int curr=0;
    public int kthSmallest(TreeNode root, int k) {
        return process(root,k).val;
    }

    public TreeNode process(TreeNode root, int k){
        if(root==null){
            return null;
        }
        TreeNode left=process(root.left,k);
        if(left!=null){
            return left;
        }
        curr++;
        if(curr==k){
            return root;
        }
        TreeNode right=process(root.right,k);
        if(right!=null){
            return right;
        }
        return null;
    }
}

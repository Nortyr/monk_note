package com.mountain.monk.leetcode;

public class NO_0230_kthSmallest {
    int num=0;
    TreeNode result=null;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return result.val;
    }

    void dfs(TreeNode root,int k){
        if(root==null) return;
        if(result!=null) return;
        num++;
        if(num==k){
            result=root;
        }
        dfs(root.left,k);
        dfs(root.right,k);
    }
}

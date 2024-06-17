package com.mountain.monk.leetcode;

public class NO_174_findTargetNode {
    //第二大，中序遍历，左中右
    int res,cnt;
    public int findTargetNode(TreeNode root, int cnt) {
        this.cnt=cnt;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if(root==null) return;
        dfs(root.right);
        if(cnt==0) {
            return;
        }
        if(--cnt==0) res=root.val;

        dfs(root.left);
    }
}

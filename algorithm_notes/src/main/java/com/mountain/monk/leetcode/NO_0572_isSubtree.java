package com.mountain.monk.leetcode;

public class NO_0572_isSubtree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {


        return pro(root,subRoot);
    }

    private boolean pro(TreeNode root, TreeNode subRoot) {
        if(root==null) return false;
        return process(root,subRoot)||pro(root.left,subRoot)||pro(root.right,subRoot);
    }

    public boolean process(TreeNode tmp,TreeNode target){
        if(tmp==null&&target==null){
            return true;
        }
        if(tmp==null||target==null||target.val!=tmp.val){
            return false;
        }
        return process(tmp.left,target.left)&&process(tmp.right,target.right);
    }
}

package com.mountain.monk.leetcode;

public class NO_0101_IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return process(root.right,root.left);
    }

    public boolean process(TreeNode left,TreeNode right){
        if(left==null&&right!=null){
            return false;
        }else if(right==null&&left!=null){
            return false;
        }else if(left==null&&right==null){
            return true;
        }
        else if (right.val!=left.val) {
            return false;
        }



        return process(left.left,right.right)&&process(left.right,right.left);
    }

    public static void main(String[] args) {
    }
}

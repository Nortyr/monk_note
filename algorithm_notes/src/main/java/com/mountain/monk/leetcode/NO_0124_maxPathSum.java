package com.mountain.monk.leetcode;

public class NO_0124_maxPathSum {
    int result=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        process(root);
        return result;

    }

    private int process(TreeNode root) {
        if(root==null){
            return 0;
        }

        int left=process(root.left);
        int right=process(root.right);
        int temp=Math.max(left,right)+root.val;
        result= Math.max(result,left+right+root.val);
        return temp;
    }


}

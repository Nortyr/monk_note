package com.mountain.monk.leetcode;

public class NO_0437_pathSum {
    /**
     * 注意：是路径和，所以要算从头开始扣，不能求和
     */
    int sum=0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        findSum(root,targetSum);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);


        return sum;
    }

    private void findSum(TreeNode root, long targetSum) {
        if (root == null) {
            return ;
        }


        if (root.val == targetSum) {
            sum ++;
        }
        findSum(root.left,targetSum-root.val);
        findSum(root.right,targetSum-root.val);


    }
}

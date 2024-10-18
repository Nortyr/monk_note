package com.mountain.monk.leetcode;

public class NO_0236_lowestCommonAncestor {
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        boolean flag= process(root,p,q);

        return flag ? ans : null;
    }

    private boolean process(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }

        boolean leftFlag=process(root.left, p, q);
        boolean rightFlag=process(root.right, p, q);
        //两边都返回true，代表此节点一定是，或者两边有一个，次节点是另一个
        if ((leftFlag && rightFlag) || ((root.val == p.val || root.val == q.val) && (leftFlag || rightFlag))) {
            ans = root;
        }
        return leftFlag || rightFlag || (root.val == p.val || root.val == q.val);

    }
}

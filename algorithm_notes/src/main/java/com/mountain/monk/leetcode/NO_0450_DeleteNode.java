package com.mountain.monk.leetcode;

public class NO_0450_DeleteNode {
    /**
     * 思路，如果左子树和右子树都存在，
     * 右子树的最左节点，可以代替根节点
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(key>root.val){
            root.right=deleteNode(root.right,key);
            return root;
        } else if (key< root.val) {
            root.left=deleteNode(root.left,key);
            return root;
        }else{
            if(root.left==null&&root.right==null){
                return null;
            } else if (root.left==null) {
                return root.right;
            } else if (root.right==null) {
                return root.left;
            }else {
                TreeNode tmp=root.right;
                while (tmp.left!=null){
                    tmp=tmp.left;
                }
                root.right=deleteNode(root.right,tmp.val);
                tmp.right=root.right;
                tmp.left=root.left;
                return tmp;
            }
        }
    }
}

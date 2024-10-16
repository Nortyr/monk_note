package com.mountain.monk.leetcode;

import java.util.LinkedList;
import java.util.List;

public class NO_0102_LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) {
            return res;
        }
        LinkedList<TreeNode> list=new LinkedList<>();
        list.add(root);
        while(!list.isEmpty()) {
            List<Integer> temp = new LinkedList<>();
            LinkedList<TreeNode> linkedList=new LinkedList<>();
            while(!list.isEmpty()) {
                TreeNode node = list.removeFirst();
                temp.add(node.val);
                if(node.left != null) {
                    linkedList.add(node.left);
                }
                if(node.right != null) {
                    linkedList.add(node.right);
                }
            }
            list=linkedList;

            res.add(temp);

        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        new NO_0102_LevelOrder().levelOrder(root);
    }
}

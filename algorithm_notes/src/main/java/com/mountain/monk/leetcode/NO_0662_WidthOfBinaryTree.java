package com.mountain.monk.leetcode;

import java.util.*;

public class NO_0662_WidthOfBinaryTree {
    Map<Integer, Integer> levelMin = new HashMap<Integer, Integer>();
    int max=0;
    /**
     * 根据位置计算，深度优先
     * @param root
     */
    public int widthOfBinaryTree(TreeNode root) {
        process(root,1,1);
        return max;
    }


    private void process(TreeNode root, int level,int i) {
        if(root==null) return;
        if(levelMin.get(level)==null)
            levelMin.put(level,i)  ;
        max=Math.max(max,i-levelMin.get(level)+1);
        process(root.left,level+1,2*i);
        process(root.right,level+1,2*i+1);
    }


    public int widthOfBinaryTree1(TreeNode root) {

        int max=0;

        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count=queue.size(),startIndex=-1,endIndex=-1;
            TreeNode node=null;
            for (int i = 0; i < count; i++) {
                node=queue.removeFirst();
                if(startIndex==-1&&node.val!=-101) startIndex= i;
                if(endIndex==-1) endIndex= i;
                queue.addLast(node.left==null?new TreeNode(-101):node.left);
                queue.addLast(node.right==null?new TreeNode(-101):node.right);
            }
            if(startIndex==-1) break;
            max=Math.max(max,endIndex-startIndex);
        }
        return max;
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(3);
        TreeNode node3=new TreeNode(4);
        TreeNode node4=new TreeNode(5);
        node.left=node1;
        node.right=node2;
        node1.left=node3;
        node2.right=node4;
        new NO_0662_WidthOfBinaryTree().widthOfBinaryTree(node);
    }

}

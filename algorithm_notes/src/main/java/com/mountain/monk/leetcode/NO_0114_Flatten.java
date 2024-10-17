package com.mountain.monk.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NO_0114_Flatten {
    List<TreeNode> list=new ArrayList<>();
    public void flatten(TreeNode root) {
        process(root);
        TreeNode head=new TreeNode(1);
        final TreeNode[] cur = {head};
        list.forEach(item->{
            item.left=null;
            cur[0].right=item;
            cur[0] =item;
        });
    }

    public void process(TreeNode root){
        if(root==null){
            return;
        }
        list.add(root);
        process(root.left);
        process(root.right);
    }
}

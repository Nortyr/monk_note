package com.mountain.monk.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NO_0199_BinaryTreeRightSideView {


    /**
     * link:https://leetcode.cn/problems/binary-tree-right-side-view/solutions/
     * 错误思路：先右后左递归
     * 错误原因，左树深层无法展示
     * 思路：层序遍历
     * @param root
     * @return
     */

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null) return list;
        process(Collections.singletonList(root),list);
        return list;
    }


    public void process(List<TreeNode> list,List<Integer> result){
        if(list.isEmpty()){
            return;
        }
        result.add(list.get(list.size()-1).val);
        List<TreeNode> newList=new ArrayList<>();
        for (TreeNode node:list){
            if(node.left!=null){
                newList.add(node.left);
            }
            if(node.right!=null){
                newList.add(node.right);
            }
        }
        process(newList,result);

    }
}

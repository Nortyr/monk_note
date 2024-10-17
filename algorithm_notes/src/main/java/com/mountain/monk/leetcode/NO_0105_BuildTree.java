package com.mountain.monk.leetcode;

import java.util.HashMap;

public class NO_0105_BuildTree {
    HashMap<Integer, Integer> indexMap = new HashMap<>();

    /**
     * 前序遍历【根，【左子树】，【右子树】】
     * 中序遍历【【左子树】，根，【右子树】】
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return process(preorder, inorder, 0, n - 1, 0, n - 1);



    }

    /**
     * 前序遍历【根，【左子树】，【右子树】】
     * 中序遍历【【左子树】，根，【右子树】】
     * @param preorder
     * @param inorder
     * @param pre_L
     * @param pre_R
     * @param inorder_L
     * @param inorder_R
     * @return
     */
    public TreeNode process(int[] preorder, int[] inorder,int pre_L,int pre_R,int inorder_L,int inorder_R){
        if(pre_L > pre_R || inorder_L > inorder_R){
            return null;
        }
        //根节点
        int preorder_root = pre_L;
        //值
        int inorder_root = indexMap.get(preorder[pre_L]);
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_L;
        //前序遍历【根，【左子树】，【右子树】】
        //前序：pre_L+1==下一个树的头结点--前序遍历
        //前序：pre_L+size_left_subtree 左子树的范围
        //中序遍历【【左子树】，根，【右子树】】
        //inorder_L左子树的左边界依然适用
        //inorder_root-1--中序位置-1
        root.left=process(preorder, inorder,pre_L+1,pre_L+size_left_subtree,inorder_L,inorder_root-1);
        //前序遍历【根，【左子树】，【右子树】】
        //前序：pre_L+size_left_subtree+1==左树结束解释右树--前序遍历
        //前序：pre_L+size_left_subtree 依然适用
        //中序：当前位置+1
        //中序：最右
        root.right=process(preorder, inorder,pre_L+size_left_subtree+1,pre_R,inorder_root+1,inorder_R);
        return root;

    }





}

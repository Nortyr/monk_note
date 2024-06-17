package com.mountain.monk.leetcode;

import java.math.BigDecimal;

/**
 * link:https://leetcode.cn/problems/sum-root-to-leaf-numbers/
 */
public class NO_0129_SumNumbers {
    int sum=0;

    public int sumNumbers(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        process(root,sb);
        return sum;
    }

    private boolean process(TreeNode root, StringBuilder sb) {
        if(root==null){
            return false;
        }

        sb.append(root.val);
        boolean flag1=process(root.left,sb);
        boolean flag2=process(root.right,sb);
        if(!flag1&&!flag2){
            sum+=Integer.parseInt(sb.toString());
        }
        sb.deleteCharAt(sb.length()-1);
        return true;
    }


}

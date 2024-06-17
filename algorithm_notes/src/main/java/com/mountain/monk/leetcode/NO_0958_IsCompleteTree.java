package com.mountain.monk.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * offer和poll是一对，源自Queue
 * add和remove是一对，源自Collection
 * push和pop是一对，源自Deque
 *
 *
 * add/offer/offerLast添加队尾，三个方法等价
 * push/offerFirst添加队头，两个方法等价。
 *
 * remove/pop/poll/pollFirst删除队头，四个方法等价；
 * pollLast删除队尾。
 */
public class NO_0958_IsCompleteTree {
    public boolean isCompleteTree(TreeNode root) {

        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.push(root);
        boolean hasNull=false;
        while(!queue.isEmpty()){


            TreeNode node=queue.poll();
            if(hasNull&&node!=null){
                return false;
            }
            if(node==null){
                hasNull=true;
                continue;
            }
            //add 添加末尾，push 添加头
            queue.add(node.left);
            queue.add(node.right);

        }

        return true;


    }
}

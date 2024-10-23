package com.mountain.monk.leetcode;

import java.util.*;

public class NO_0207_CanFinish {
    public class Node{
        int in=0;
        public List<Node> friends =new ArrayList<>();

        public Node(int in ){
            this.in=in;
        }

    }
    //需要修[i][0]必须先修[i][1],所以0的入度就是1，1的入度就是1
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            int[] indegree = new int[numCourses];
            Node cur=null;
            if(map.containsKey(indegree[0])){
                cur= map.get(indegree[0]);
                cur.in++;
            } else{
                 cur = new Node(1);
            }
            //前置
            if(!map.containsKey(prerequisites[i][1])){
                //需要节点的入度为0
                map.put(prerequisites[i][1],new Node(0));
            }
            map.get(prerequisites[i][1]).friends.add(map.get(prerequisites[i][0]));
        }
        LinkedList<Node> queue=new LinkedList <>();
        //如果根本没有入度是0的，根本不可能完成
        for(Integer key:map.keySet()){
            Node node=map.get(key);
            if(node.in==0){
                queue.add(node);
            }
        }

        while(!queue.isEmpty()){
            Node node=queue.pollFirst();
            for(Node no:node.friends){
                no.in--;
                if(no.in==0){
                    queue.add(no);
                }
            }
        }
        int count=0;
        for(Integer key:map.keySet()){
            Node node=map.get(key);
            if(node.in!=0){
                count++;
            }
        }





        return count==0;
    }
}

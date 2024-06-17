package com.mountain.monk.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NO_0138_CopyRandomList {
    public Node copyRandomList(Node head) {
        Node next=head,pre=null;
        Map<Node,Node> map=new HashMap<>();
        while (next!=null){

            map.put(next,new Node(next.val));
            if(pre!=null){
                map.get(pre).next=map.get(next);
            }
            pre=next;
            next=next.next;
        }
        for (Map.Entry<Node,Node>entry:map.entrySet()){
            entry.getValue().random=map.get(entry.getKey().random);
        }


        return map.get(head);
    }
}

package com.mountain.monk.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NO_0138_CopyRandomList {
    public Node copyRandomList(Node head) {
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        map.forEach((k, v) -> {
            v.next = map.get(k.next);
            v.random = map.get(k.random);
        });
        return map.get(head);
    }
}

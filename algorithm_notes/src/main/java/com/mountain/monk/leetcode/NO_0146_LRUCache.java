package com.mountain.monk.leetcode;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class NO_0146_LRUCache {


}

class LRUCache {
    Map<Integer, Integer> map;
    int capacity;
    public LRUCache(int capacity) {
        map=new LinkedHashMap<>(capacity);
        this.capacity=capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            int value=map.remove(key);

            map.put(key,value);
        }

        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            map.remove(key);
        } else if (map.size()>=capacity) {
            Iterator it=map.keySet().iterator();
            Object key1 = it.next();
            map.remove(key1);
        }

        map.put(key, value);
    }
}

class LRUCache1 extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache1(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    // 这个可不写
    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

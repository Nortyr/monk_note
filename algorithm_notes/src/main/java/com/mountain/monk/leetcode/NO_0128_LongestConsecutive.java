package com.mountain.monk.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class NO_0128_LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],0);
        }
        int result=0;
        for (Integer i:map.keySet()){
            if(map.get(i)==0){
                int cur=i;
                int curCount=0;
                while(map.containsKey(cur)){
                    if(map.get(i)!=0){
                        curCount+=map.get(i);
                        break;
                    }
                    curCount++;
                    cur++;
                }
                //缓存加速
                for (int j = curCount,tmp=i;map.containsKey(tmp)&&map.get(tmp)==0; tmp++, j--) {
                    map.put(tmp,j);
                }
                result=Math.max(result,curCount);

            }
        }
        return result;

    }

    public static void main(String[] args) {
        new NO_0128_LongestConsecutive().longestConsecutive(new int[]{100,4,200,6,8,10});
    }
}

package com.mountain.monk.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class NO_0076_MinWindow {
    Map<Character,Integer> target=new HashMap<>();
    Map<Character,Integer> map=new HashMap<>();
    public String minWindow(String s, String t) {
        for (Character c:t.toCharArray()){
            target.put(c,target.getOrDefault(c,0)+1);
        }
        int start=-1,end=-1,len = Integer.MAX_VALUE;
        int l=0,r=-1;
        while(r<s.length()){
            r++;
            if(r<s.length()&&target.containsKey(s.charAt(r))){
                map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            }
            while (l<=r&&check()){
                //记录最小值
                if (r-l+1<len){
                    len=r-l+1;
                    start=l;
                    end = l+len;
                }
                if(target.containsKey(s.charAt(l)))
                    map.put(s.charAt(l),map.getOrDefault(s.charAt(l),0)-1);

                l++;

            }
        }
        return start == -1 ? "" : s.substring(start, end);

    }

    public boolean check(){
        AtomicBoolean flag= new AtomicBoolean(true);
        target.forEach((key, value) ->{
            Integer mapValue=map.getOrDefault(key,0);
            if(mapValue<value){

                flag.set(false);
            }
        } );
        return flag.get();
    }
}

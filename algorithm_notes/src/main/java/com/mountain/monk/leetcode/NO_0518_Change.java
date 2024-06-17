package com.mountain.monk.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NO_0518_Change {



    int result = 0;
    Map<String, Integer> memo = new HashMap<>();

    public int change(int amount, int[] coins) {
        return process(amount, coins, 0);
    }

    private int process(int amount, int[] coins, int i) {
        if (amount == 0) {
            return 1;
        }
        if (i >= coins.length || amount < 0) {
            return 0;
        }
        String key = amount + "-" + i;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int ways = 0;
        int end = amount / coins[i];
        for (int j = 0; j <= end; j++) {
            ways += process(amount - coins[i] * j, coins, i + 1);
        }

        memo.put(key, ways);
        return ways;
    }


//------------------------递归-------------------------------
//    int result=0;
//    public int change(int amount, int[] coins) {
//
//        process(amount,coins,0);
//        return result;
//    }
//
//    private void process(int amount, int[] coins, int i) {
//        if(amount==0){
//            result++;
//            return;
//        }
//        if(i>=coins.length||amount<0){
//            return;
//        }
//        int end=amount/coins[i];
//        for (int j = 0; j <=end; j++) {
//            process(amount-coins[i]*j,coins,i+1);
//        }
//    }
}

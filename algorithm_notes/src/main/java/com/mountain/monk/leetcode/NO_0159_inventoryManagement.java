package com.mountain.monk.leetcode;

import java.util.Arrays;

public class NO_0159_inventoryManagement {

    public int[] inventoryManagement(int[] stock, int cnt) {
        Arrays.sort(stock);
        return Arrays.copyOf(stock, cnt);
    }
}

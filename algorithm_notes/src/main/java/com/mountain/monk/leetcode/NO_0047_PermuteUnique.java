package com.mountain.monk.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

public class NO_0047_PermuteUnique {
    List<Integer> nums=new ArrayList<>();
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        for (int num : nums) {
            this.nums.add(num);
        }
        dfs(0);
        return res;

    }

    private void dfs(int x) {
        if(x==nums.size()-1){
            res.add(new ArrayList<>(nums));  // 添加排列方案
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = x; i < nums.size(); i++) {
            if (set.contains(nums.get(i)))
                continue;            // 重复，因此剪枝
            set.add(nums.get(i));
            swap(i, x);              // 交换，将 nums[i] 固定在第 x 位
            dfs(x + 1);              // 开启固定第 x + 1 位元素
            swap(i, x);              // 恢复交换
        }


    }
    void swap(int a, int b) {
        int tmp = nums.get(a);
        nums.set(a, nums.get(b));
        nums.set(b, tmp);
    }


}

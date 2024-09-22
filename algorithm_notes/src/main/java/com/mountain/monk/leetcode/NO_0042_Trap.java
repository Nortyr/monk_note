package com.mountain.monk.leetcode;

import java.util.*;


public class NO_0042_Trap {
    public int trap(int[] height) {
        int ans = 0;
        //单调栈从大到小
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < height.length; i++) {
            //按层计算水
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty() ) {
                    break;
                }
                int left =stack.peek();
                int curWidth = i-left-1;
                int curHeight = Math.min(height[left],height[i])-height[top];
                ans+=curWidth*curHeight;

            }
            stack.push(i);
        }
        return ans;
    }



    /**
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     *
     * 返回 滑动窗口中的最大值 。
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!stack.isEmpty()&&nums[stack.peekLast()]<=nums[i]){
                stack.pollLast();
            }
            stack.addLast(i);
        }
        int[] ans = new int[nums.length - k + 1];
        ans[0] = nums[stack.peekFirst()];


        for (int i = k; i < nums.length; i++) {
            while (!stack.isEmpty()&&nums[stack.peekLast()]<=nums[i]){
                stack.pollLast();
            }
            stack.addLast(i);
            while (stack.peekFirst()<(i-k+1)) {
                stack.pollFirst();
            }

            ans[i-k+1] = nums[stack.peekFirst()];


        }
        return ans;
    }

    public int maxSubArray(int[] nums) {
        int min=0,max=nums[0];

        for (int i = 0; i < nums.length; i++) {

            min=Math.max(min+nums[i],nums[i]);
            max=Math.max(max,min);
        }
        return max;
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);



    }
    public static void main(String[] args) {
        new NO_0042_Trap().maxSlidingWindow(new int[]{1,3,1,2,0,5},3);
    }
}

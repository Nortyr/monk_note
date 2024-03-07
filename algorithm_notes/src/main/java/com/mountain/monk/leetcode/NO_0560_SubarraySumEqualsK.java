package com.mountain.monk.leetcode;

public class NO_0560_SubarraySumEqualsK {

    /**
     * 累加和
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int result=0;
        int[] sumArr=new int[nums.length];
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            sumArr[i]=sum;
        }

        for (int i = sumArr.length-1; i >=0 ; i--) {
            if(sumArr[i]==k){
                result++;
            }
            for (int j = 0; j < i; j++) {
                if(sumArr[i]-sumArr[j]==k){
                    result++;
                }
            }
        }
        return result;

    }

}

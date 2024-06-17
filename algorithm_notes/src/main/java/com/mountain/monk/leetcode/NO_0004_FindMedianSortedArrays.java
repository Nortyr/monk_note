package com.mountain.monk.leetcode;

public class NO_0004_FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total=nums1.length+nums2.length;
        boolean flag=total%2==0;
        int n=0,m=0,cur=0,sum=0;
        while(n<nums1.length&&m<nums2.length){
            if(cur>=total/2-1&&cur<=total/2){
                if(flag){
                    sum+=Math.min(nums1[n],nums2[m]);
                }else{
                    if(cur==total/2)
                        sum+=Math.min(nums1[n],nums2[m]);
                }
            }
            if(nums1[n]<=nums2[m]){
                n++;
            }else{
                m++;
            }
            cur++;
        }
        if(cur>total/2){
            return flag?sum/2.0D:(double) sum;
        }else{
            while (n<nums1.length){
                if(cur>=total/2-1&&cur<=total/2){
                    if(flag){
                        sum+=nums1[n];
                    }else{
                        if(cur==total/2)
                            sum+=nums1[n];
                    }
                }
                n++;
                cur++;
            }
            while (m<nums2.length){
                if(cur>=total/2-1&&cur<=total/2){
                    if(flag){
                        sum+=nums2[m];
                    }else{
                        if(cur==total/2)
                            sum+=nums2[m];
                    }
                }
                m++;
                cur++;
            }
        }


        return flag?sum/2.0D:(double) sum;
    }
}

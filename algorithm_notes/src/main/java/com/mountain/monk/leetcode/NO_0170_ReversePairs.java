package com.mountain.monk.leetcode;

public class NO_0170_ReversePairs {
    public int reversePairs(int[] record) {
        if(record==null||record.length<=1) return 0;
        return process(record,0,record.length-1);
    }

    private int process(int[] arr, int L,int R) {
        if(L>=R) return 0;
        int mid=(L+R)/2;
        return process(arr,L,mid)+process(arr,mid+1,R)+merge(arr,L,mid,R);
    }

    private int merge(int[] arr, int L,int mid,int R) {
        int []help=new int[R-L+1];
        int i=0;
        int p1=L;
        int p2=mid+1;
        int res=0;
        while(p1<=mid&&p2<=R){
            if(arr[p1]<=arr[p2]){
                help[i++]=arr[p1++];
            }else{
                //总体有序
                res+=(mid-p1+1);
                help[i++]=arr[p2++];
            }
        }
        while (p1<=mid){
            help[i++]=arr[p1++];
        }
        while(p2<=R){
            help[i++]=arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L+i]=help[i];
        }
        return res;



    }

}

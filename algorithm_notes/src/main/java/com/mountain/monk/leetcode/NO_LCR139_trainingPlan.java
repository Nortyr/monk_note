package com.mountain.monk.leetcode;

public class NO_LCR139_trainingPlan {
    public int[] trainingPlan(int[] actions) {
        if(actions.length<2)return actions;
        int l=0,r=actions.length-1;
        int [] result=new int[actions.length];
        while (l<r){
            while (l<r&& actions[l]%2==1){
                l++;
            }
            while (l<r&&actions[r]%2==0){
                r--;
            }
            swap(actions,l,r);
        }
        return actions;

    }

    public void swap(int[] arr,int l,int r){
        int tmp=arr[r];
        arr[r]=arr[l];
        arr[l]=tmp;

    }
}

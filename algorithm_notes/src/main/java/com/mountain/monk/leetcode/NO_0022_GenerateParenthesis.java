package com.mountain.monk.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NO_0022_GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        char [] charsArr=new char[2*n];
        List<String> list=new ArrayList<>();
        process(n,0,0,charsArr,list);
        return list;
    }

    private void process(int n, int left, int right, char[] charsArr, List<String> list) {
        if(right>left){
            return;
        }
        if(left==n&&right==n){
            list.add(String.valueOf(charsArr));
            return;
        }
        if(left==right){
            charsArr[left+right]='(';
            process(n,left+1,right,charsArr,list);
        } else if (left==n) {
            charsArr[left+right]=')';
            process(n,left,right+1,charsArr,list);
        }else {
            charsArr[left+right]='(';
            process(n,left+1,right,charsArr,list);
            charsArr[left+right]=')';
            process(n,left,right+1,charsArr,list);
        }


    }
}

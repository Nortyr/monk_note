package com.mountain.monk.leetcode;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {

    }

    public int addString(String a,String b){
        return Integer.parseInt(a)+Integer.parseInt(b);

    }

    public BigDecimal addString2(String a,String b){
        BigDecimal numberA=new BigDecimal(a);
        BigDecimal numberB=new BigDecimal(b);
        return numberA.add(numberB);
//        return numberA.add();

    }
}

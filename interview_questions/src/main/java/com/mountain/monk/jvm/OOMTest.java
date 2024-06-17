package com.mountain.monk.jvm;

import java.util.ArrayList;
import java.util.List;

public class OOMTest {

    public static void main(String[] args) {

        Thread thread=new Thread(()->{
            List<Object> list1=new ArrayList<>();
            while (true){
                list1.add(new Object());
            }
        });
       thread.setUncaughtExceptionHandler((t,ex)->{
           //donothing
           System.out.println("处理 OOM");
       });
        thread.start();
        new Thread(()->{
            while (true){
                System.out.println(1111);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        List<Object> list=new ArrayList<>();
        while (true){
            list.add(new Object());
        }
    }
}

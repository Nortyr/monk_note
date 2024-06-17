package com.mountain.monk.jvm;

public class DeadLockDemo {


    public static void main(String[] args) {

      Object lock1 = new Object();
      Object lock2 = new Object();
        new Thread(() -> {
            synchronized (lock1) {
                sleep(2000);
                synchronized (lock2) {
                    System.out.println("myThread1 over");
                }
            }
        },"myThread1").start();

        new Thread(() -> {
            synchronized (lock2) {
                sleep(2000);
                synchronized (lock1) {
                    System.out.println("myThread1 over");
                }
            }
        },"myThread2").start();
    }

    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

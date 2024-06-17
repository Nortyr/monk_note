package com.mountain.monk.basis;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompleteFutureDemo {

    public static void main(String[] args) {
        // 异步任务1：返回一个字符串
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000); // 模拟耗时操作
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello";
        });

        // 异步任务2：返回一个整数
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000); // 模拟耗时操作
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        }).handle((res,ex)->{
            if(ex==null) return res;
            ex.printStackTrace();
            return -1;
        });


        // thenCombine 结果进行组合
        // thenCombine: 组合两个 CompletableFuture 的结果，并执行 BiFunction 函数
        CompletableFuture<String> combinedFuture = future1.thenCombine(future2, (result1, result2) -> {
            return result1 + " " + result2;
        }).exceptionally(ex->{
            ex.printStackTrace();   //异常处理，此处选择打印调用异常栈

            return "";
        });

        //穿行执行
        // thenCompose: 将一个 CompletableFuture 的结果传递给另一个 CompletableFuture
        CompletableFuture<String> composedFuture = future1.thenCompose(result1 -> {
            return CompletableFuture.supplyAsync(() -> result1 + " World");
        });


        //任务1结束触发任务2无返回值
        // thenAccept: 处理 CompletableFuture 的结果，不返回值
        future2.thenAccept(result -> {
            System.out.println("Result from future2: " + result);
        });
        //任务1结束触发任务2有返回值
        // thenApply: 处理 CompletableFuture 的结果，并返回一个新的 CompletableFuture 对象
        CompletableFuture<Integer> appliedFuture = future2.thenApply(result -> result * 2);

        //任务1处理完执行
        // thenRun: 处理 CompletableFuture 完成时的操作，不接受参数，也不返回结果
        future1.thenRun(() -> {
            System.out.println("Future1 completed");
        });

        // 等待所有异步任务完成
        try {
            System.out.println(combinedFuture.get());
            System.out.println(composedFuture.get());
            System.out.println(appliedFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

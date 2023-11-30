package com.controller.bootweb.demo.thread;

import com.google.common.util.concurrent.*;

import java.util.List;
import java.util.concurrent.Executors;

public class ThreadCoordinationExample {

    public static void main(String[] args) {
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(3));

        ListenableFuture<Void> futureA = Futures.submitAsync( () -> {
            // 执行任务 A
            System.out.println("Task A executed" + System.currentTimeMillis());
            Thread.sleep(100000);
            return Futures.immediateFuture(null);
        },executorService);

        ListenableFuture<Void> futureB = Futures.submitAsync(() -> {
            // 执行任务 B
            System.out.println("Task B executed"+ System.currentTimeMillis());

            return Futures.immediateFuture(null);
        },executorService);

        // 使用 Futures.allAsList 组合任务 A 和任务 B
        ListenableFuture<List<Void>> combinedFuture = Futures.allAsList(futureB,futureA);

        // 在任务 C 中等待任务 A 和任务 B 完成
        ListenableFuture<Void> futureC = Futures.transformAsync(combinedFuture, input -> {
            // 执行任务 C
            System.out.println("Task C executed");
            return Futures.immediateFuture(null);
        }, executorService);

        // 注册回调，当任务 C 完成时输出消息
        Futures.addCallback(futureC, new FutureCallback<Void>() {
            @Override
            public void onSuccess(Void result) {
                System.out.println("All tasks completed");
                executorService.shutdown();
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("Failure: " + t.getMessage());
                executorService.shutdown();
            }
        }, executorService);
    }
}


package com.controller.bootweb.demo.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Test9373 {

//    public static void main(String[] args) throws InterruptedException {
//        System.out.println("Action...GO!");
//        Semaphore semaphore = new Semaphore(5);
//        for (int i = 0; i < 10; i++) {
//            Thread t = new Thread(new SemaphoreWorker(semaphore));
//            t.start();
//        }
//    }

//    public static void main(String[] args) throws InterruptedException {
//        Semaphore semaphore = new Semaphore(0);
//        for (int i = 0; i < 10; i++) {
//            Thread t = new Thread(new MyWorker(semaphore));
//            t.start();
//        }
//        System.out.println("Action...GO!");
//        semaphore.release(5);
//        System.out.println("Wait for permits off");
//        while (semaphore.availablePermits()!=0) {
//            Thread.sleep(100L);
//        }
//        System.out.println("Action...GO again!");
//        semaphore.release(5);
//    }

//    public static void main(String[] args) throws InterruptedException {
//        CountDownLatch latch = new CountDownLatch(6);
//        for (int i = 0; i < 5; i++) {
//            Thread t = new Thread(new FirstBatchWorker(latch));
//            t.start();
//        }
//        for (int i = 0; i < 5; i++) {
//            Thread t = new Thread(new SecondBatchWorker(latch));
//            t.start();
//        }
//        // 注意这里也是演示目的的逻辑，并不是推荐的协调方式
//        while ( latch.getCount() != 1 ){
//            Thread.sleep(100L);
//        }
//        System.out.println("Wait for first batch finish");
//        latch.countDown();
//    }

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("Action...GO again!");
            }
        });
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new CyclicWorker(barrier));
            t.start();
        }
    }

    static class CyclicWorker implements Runnable {
        private CyclicBarrier barrier;
        public CyclicWorker(CyclicBarrier barrier) {
            this.barrier = barrier;
        }
        @Override
        public void run() {
            try {
                for (int i=0; i<3 ; i++){
                    System.out.println("Executed!"+Thread.currentThread().getId());
                    barrier.await();
                }
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SemaphoreWorker implements Runnable {
    private String name;
    private Semaphore semaphore;
    public SemaphoreWorker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }
    @Override
    public void run() {
        try {
            log("is waiting for a permit!");
            semaphore.acquire();
            log("acquired a permit!");
            log("executed!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            log("released a permit!");
            semaphore.release();
        }
    }
    private void log(String msg){
        if (name == null) {
            name = Thread.currentThread().getName();
        }
        System.out.println(name + " " + msg);
    }
}


class MyWorker implements Runnable {
    private Semaphore semaphore;
    public MyWorker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }
    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("Executed!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class FirstBatchWorker implements Runnable {
    private CountDownLatch latch;
    public FirstBatchWorker(CountDownLatch latch) {
        this.latch = latch;
    }
    @Override
    public void run() {
        System.out.println("First batch executed!");
        latch.countDown();
    }
}
class SecondBatchWorker implements Runnable {
    private CountDownLatch latch;
    public SecondBatchWorker(CountDownLatch latch) {
        this.latch = latch;
    }
    @Override
    public void run() {
        try {
            latch.await();
            System.out.println("Second batch executed!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


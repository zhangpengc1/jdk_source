package com.marton.base.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 闭锁 Latch，基于AQS实现
 * 可以延迟线程的进度直到达到最终状态，实现CountDownLatch。
 *
 * new CountDownLatch(5); // setState = 10
 * 每 countDown 一下 state -1
 * 当 state = 0 的时候 doReleaseShared() unpark头节点
 *
 * 何时唤醒？ doAcquireSharedInterruptibly --> setHeadAndPropagate
 */
public class LatchDemo {

    public static ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(5); // setState = 10

        for (int i = 0; i < 5; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("hello");

                    countDownLatch.countDown();
                }
            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("ok");
    }

}

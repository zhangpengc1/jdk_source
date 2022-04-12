package com.marton.base.juc.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：zhangp
 * @Date ：2022/4/6 下午5:53
 * @desc :
 */
public class ThreadPool_Exception {

    private static ExecutorService executorService = new ThreadPoolExecutor(5, 5,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());

    public static void main(String[] args) {


        System.out.println("预热线程数：" + ((ThreadPoolExecutor) executorService).getActiveCount());
        // 先预热
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("预热线程数：" + ((ThreadPoolExecutor) executorService).getActiveCount());

                }
            });
        }

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


       // AtomicInteger atomicInteger = new AtomicInteger(1);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {

                    System.out.println("活跃线程数：" + ((ThreadPoolExecutor) executorService).getActiveCount());
                    System.out.println(1 / 0);

                }
            });
        }


    }

}

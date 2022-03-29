package com.marton.base.juc.pool;

import java.util.concurrent.*;

public class ThreadPool_sch {


    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

//        scheduledExecutorService.schedule(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("hello-java  " + Thread.currentThread().getName());
//            }
//        }, 5, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println(System.currentTimeMillis() + " hello-java  " + Thread.currentThread().getName());
            }
        }, 2, 2, TimeUnit.SECONDS);
    }


}

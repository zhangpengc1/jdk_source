package com.marton.base.juc.pool;

import java.util.concurrent.*;

/**
 * @author ：zhangp
 * @Date ：2022/4/6 下午5:53
 * @desc :
 */
public class ThreadPool_KeepTime {

    private static ExecutorService executorService = new ThreadPoolExecutor(5, 5,
            5000L, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(2));

    public static void main(String[] args) {

        System.out.println("预热线程数：" + ((ThreadPoolExecutor) executorService).getPoolSize());
        // 先预热
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println("预热线程数：" + ((ThreadPoolExecutor) executorService).getPoolSize());

                }
            });
        }


                            try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
        BlockingQueue<Runnable> queue = ((ThreadPoolExecutor) executorService).getQueue();
        System.out.println(queue.size());



    }

}

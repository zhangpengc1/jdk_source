package com.marton.base.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量 Semphore
 * 用来控制同时访问某个特定资源的操作数量，或者同时执行某个指定操作的数量，比如可以实现数据库连接池。
 * <p>
 * acquire 获取许可，获取到许可就可以继续执行，没有获取到许可就等待呗
 * release 释放获取到的许可
 *
 * state < 0 阻塞
 * > 0 释放
 */
public class SemphoreDemo {

    public static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        Semaphore semphore = new Semaphore(1);

        for (int i = 0; i < 5; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        semphore.acquire(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    long timeMillis = System.currentTimeMillis();

                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("我获得令牌了，我执行。" + Thread.currentThread().getName());
                    System.out.println("jiange{}" + (timeMillis - System.currentTimeMillis()));
                    semphore.release(1);
                }
            });
        }

    }

}

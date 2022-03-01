package com.marton.base.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 字面意思回环栅栏，通过它可以实现让一组线程等待至某个状态之后再全部同时执行。
 * 叫做回环是因为当所有等待线程都被释放以后，CyclicBarrier可以被重用。
 * <p>
 * 默认的构造方法是CyclicBarrier(int parties)，其参数表示屏障拦截的线程数量，
 * 每个线程调用await方法告诉CyclicBarrier已经到达屏障位置，线程被阻塞。
 * <p>
 * 与LatchDemo的区别？
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Worker("张" + i, cyclicBarrier));
        }
    }

    public static class Worker implements Runnable {

        private String name;

        private CyclicBarrier cyclicBarrier;

        public Worker(String name, CyclicBarrier cyclicBarrier) {
            this.name = name;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(name + "起跑== " + System.currentTimeMillis());
        }
    }


}

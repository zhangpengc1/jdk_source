package com.marton.base.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class AQSConditionDemo {

    public static ReentrantLock reentrantLock = new ReentrantLock();

    public static Condition notNullCondition = reentrantLock.newCondition();

    public static Condition notEmptyCondition = reentrantLock.newCondition();

    public static List<Integer> sourceList = new ArrayList<>();

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Producer(sourceList));

        Thread thread2 = new Thread(new Consumer(sourceList));

        thread1.start();
        thread2.start();

    }

    public static class Producer implements Runnable {

        public List<Integer> sourceList;

        public Producer(List<Integer> sourceList) {
            this.sourceList = sourceList;
        }

        @Override
        public void run() {
            while (true) {
                reentrantLock.lock();

                if (!sourceList.isEmpty()) {
                    try {
                        notNullCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int nextInt = new Random(5).nextInt();
                sourceList.add(nextInt);
                System.out.println("我生产了" + nextInt);

                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                notEmptyCondition.signal();

                reentrantLock.unlock();
            }
        }
    }

    public static class Consumer implements Runnable {

        public List<Integer> sourceList;

        public Consumer(List<Integer> sourceList) {
            this.sourceList = sourceList;
        }

        @Override
        public void run() {
            while (true) {
                reentrantLock.lock();

                if (sourceList.isEmpty()) {
                    try {
                        notEmptyCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("我消费了..." + sourceList.remove(0));

                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                notNullCondition.signal();

                reentrantLock.unlock();
            }


        }

    }


}

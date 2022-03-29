package com.marton.base.juc.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;


public class SynchronousQueue_Demo {

    private static final SynchronousQueue<String> blockQueue = new SynchronousQueue();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    String poll = null;
                    try {
                        poll = blockQueue.poll(2000,TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("poll result:" + poll);
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    boolean offer = false;
                    try {
                        offer = blockQueue.offer(i + "",1000L, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("offer result :" + offer);

                }
            }
        }).start();

    }
}

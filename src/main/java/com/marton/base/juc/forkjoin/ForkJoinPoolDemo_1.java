package com.marton.base.juc.forkjoin;

import java.util.ArrayList;

public class ForkJoinPoolDemo_1 {

    public static void main1(String[] args) {
        ArrayList<String> arrayList = new ArrayList();
        for (int i = 0; i < 50; i++) {
            arrayList.add(i + "");
        }

        /**
         * Thread[main,5,main]---0
         * Thread[main,5,main]---1
         * Thread[main,5,main]---2
         * Thread[main,5,main]---3
         * Thread[main,5,main]---4
         * Thread[main,5,main]---5
         * Thread[main,5,main]---6
         * Thread[main,5,main]---7
         * Thread[main,5,main]---8
         */
        arrayList.stream().forEach(e->{
            System.out.println(Thread.currentThread() + "---" +e);
        });
        /**
         * Thread[ForkJoinPool.commonPool-worker-5,5,main]---7
         * Thread[ForkJoinPool.commonPool-worker-6,5,main]---26
         * Thread[ForkJoinPool.commonPool-worker-5,5,main]---8
         * Thread[ForkJoinPool.commonPool-worker-2,5,main]---44
         * Thread[ForkJoinPool.commonPool-worker-1,5,main]---15
         */
        arrayList.parallelStream().forEach(e->{
            System.out.println(Thread.currentThread() + "---" +e);
        });

    }

}

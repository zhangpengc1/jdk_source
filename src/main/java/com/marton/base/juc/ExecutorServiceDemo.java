package com.marton.base.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(1);


        executorService.submit(new Runnable() {
            @Override
            public void run() {

            }
        });


        executorService.execute(new Runnable() {
            @Override
            public void run() {

            }
        });

        executorService.shutdown();


        executorService.shutdownNow();

    }

}

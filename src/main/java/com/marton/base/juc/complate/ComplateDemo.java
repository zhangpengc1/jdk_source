package com.marton.base.juc.complate;

import java.util.concurrent.*;

public class ComplateDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<MyPacket> completableFuture = CompletableFuture.supplyAsync(() -> {

            MyPacket myPacket = new MyPacket();
            // 发request
            String request = myPacket.getRequest();
            // 处理response

            return myPacket;
        });


        MyPacket myPacket = completableFuture.join();

        System.out.println(myPacket);

        System.out.println("hello this is my?");

    }


}

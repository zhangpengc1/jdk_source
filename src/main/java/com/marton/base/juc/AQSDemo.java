package com.marton.base.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AQSDemo {

    public static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {

        reentrantLock.lock();

        boolean 吃过饭没 = true;

        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("do something");

        reentrantLock.unlock();
    }


}

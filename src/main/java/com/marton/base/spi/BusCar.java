package com.marton.base.spi;

/**
 * @author ：zhangp
 */
public class BusCar implements Car {

    @Override
    public void run() {
        System.out.println("BusCar Run...");
    }
}
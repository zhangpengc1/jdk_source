package com.marton.base.spi;

/**
 * @author ：zhangp
 * @Date ：2022/4/8 上午10:35
 * @desc : 
 */
public class Bicycle implements Car {

    @Override
    public void run() {
        System.out.println("Bicycle Run...");
    }
}
package com.marton.base.spi;

/**
 * @author ：zhangp
 * @Date ：2022/4/8 上午10:35
 * @desc : 
 */
public class Dog implements IShout{

    @Override
    public void shout() {
        System.out.println("Dog shout");
    }
}
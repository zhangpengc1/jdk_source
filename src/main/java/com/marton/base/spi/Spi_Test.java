package com.marton.base.spi;

import java.util.ServiceLoader;

/**
 * @author ：zhangp
 * @Date ：2022/4/8 上午10:33
 * @desc : 
 */
public class Spi_Test {


    public static void main(String[] args) {
        ServiceLoader<IShout> shouts = ServiceLoader.load(IShout.class);

        for (IShout s : shouts) {
            s.shout();
        }



    }

}

package com.marton.base.spi;

import java.util.ServiceLoader;

/**
 * @author ：zhangp
 * @Date ：2022/4/8 上午10:33
 * @desc : 
 */
public class Spi_Test {

    public static void main(String[] args) {
        ServiceLoader<Car> cars = ServiceLoader.load(Car.class);

        for (Car s : cars) {
            s.run();
        }
    }

}

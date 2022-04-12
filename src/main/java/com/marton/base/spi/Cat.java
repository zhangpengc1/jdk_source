package com.marton.base.spi; /**
 * @title: Cat
 * @projectName jdk_source
 * @description: TODO
 * @author zhangpeng
 * @date 2022/4/8  上午10:36
 */

/**
 *
 * @author ：zhangp
 * @Date ：2022/4/8 上午10:36
 * @desc : 
 */
public class Cat implements IShout{

    @Override
    public void shout() {
        System.out.println("Cat shout");
    }
}
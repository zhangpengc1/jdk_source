package com.marton.base.io;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author ：zhangp
 * @Date ：2022/4/22 下午4:09
 */
public class IO_File {

    public static void main(String[] args) {

        System.out.println("hello");

        File file = new File("/Users/zhangpeng/Desktop/java");

        System.out.println(file.exists());

        System.out.println(file.canRead());




    }
}

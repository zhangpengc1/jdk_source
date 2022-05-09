package com.marton.base.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * InputStream
 * <p>
 * 是Java IO API中所有输入流的父类。
 * 表示有序的字节流，换句话说，可以将 InputStream 中的数据作为有序的字节序列读取。
 * 这在从文件读取数据或通过网络接收时非常有用。
 * InputStream 通常连接到某些数据源，如文件，网络连接，管道等
 */
public class IO_InputStream_1 {

    public static void main(String[] args) {

        StringBuffer stringBuffer = new StringBuffer();

        try {
            long start = System.currentTimeMillis();

            InputStream inputStream = new FileInputStream("/Users/zhangpeng/Desktop/java");

            int i = 0;
            while ((i = inputStream.read()) != -1) {
                stringBuffer.append((char) i);
            }
            System.out.println(stringBuffer.toString());

            System.out.println("耗费时间：" + (System.currentTimeMillis() - start));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main1(String[] args) {

        StringBuffer stringBuffer = new StringBuffer();

        try {
            long start = System.currentTimeMillis();

            InputStream inputStream = new FileInputStream("/Users/zhangpeng/Desktop/hello");

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            int i;
            while ((i = inputStreamReader.read()) != -1) {
                stringBuffer.append((char) i);
            }
            System.out.println(stringBuffer.toString());

            System.out.println("耗费时间：" + (System.currentTimeMillis() - start));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

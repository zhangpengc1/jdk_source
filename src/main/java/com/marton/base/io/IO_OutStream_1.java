package com.marton.base.io;

import java.io.*;

/**
 * OutputStream
 * <p>
 * OutputStream 通常始终连接到某个数据目标，
 * 如文件，网络连接，管道等。 OutputStream 的目标是将数据写入到外部。
 * <p>
 * outputStream.write 一个字节一个字节的write
 */
public class IO_OutStream_1 {


    public static void main2(String[] args) {

        try {
            long start = System.currentTimeMillis();

            OutputStream bufferedOutputStream = new FileOutputStream("/Users/zhangpeng/Desktop/hello");

            bufferedOutputStream.write("hello,this is first write! dou you know?".getBytes());
            bufferedOutputStream.flush();

            System.out.println("耗费时间：" + (System.currentTimeMillis() - start));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try {
            long start = System.currentTimeMillis();


            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("/Users/zhangpeng/Desktop/hello"));

            bufferedOutputStream.write("hello,this is first write! dou you know? ss ".getBytes());
            bufferedOutputStream.flush();

            System.out.println("耗费时间：" + (System.currentTimeMillis() - start));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main1(String[] args) {
        try {
            long start = System.currentTimeMillis();

            //OutputStream outputStream = new FileOutputStream("/Users/zhangpeng/Desktop/hello");

            Writer writer = new FileWriter(new File("/Users/zhangpeng/Desktop/hello"));
            writer.write("hello,this is first write! dou you know? haha");
            writer.flush();

            System.out.println("耗费时间：" + (System.currentTimeMillis() - start));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

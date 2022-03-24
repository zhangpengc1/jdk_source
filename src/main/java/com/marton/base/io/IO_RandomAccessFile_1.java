package com.marton.base.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile 随机访问文件
 *
 * 这里的随机访问是指，指定任何一个位置，都能够访问它；而不是不确定的随机访问某一个位置。
 * 在使用 RandomAccessFile 类之前，必须实例化它
 *
 * "r"  - 以只读方式打开。调用结果对象的任何 write 方法都将导致抛出 IOException。
 * "rw" - 打开以便读取和写入。如果该文件尚不存在，则尝试创建该文件。
 * "rws"- "rw" + “sync”，另外还要求对文件的内容或元数据的每个更新都同步写入到底层存储设备。
 * "rwd"- "rw" + “data”，另外还要求对文件内容的每个更新都同步写入到底层存储设备。
 */

public class IO_RandomAccessFile_1 {

    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("/Users/zhangpeng/Desktop/hello", "rw");

        System.out.println("pointer: " + file.getFilePointer()); // 输出 pointer: 0
        System.out.println("char: " + (char) file.read()); // 输出 char: 1
        System.out.println("pointer: " + file.getFilePointer()); // 输出 pointer: 1

        file.seek(4); // 下标从 0 开始的，让其指向第 5 个字节

        System.out.println("pointer: " + file.getFilePointer()); // 输出 pointer: 4
        System.out.println("char: " + (char) file.read()); // 输出 char: 5
        System.out.println("pointer: " + file.getFilePointer()); // 输出 pointer: 5
        file.close();
    }


}

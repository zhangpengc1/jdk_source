package com.marton.base.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

public class NIO_Transfer_1 {

    public static void main(String[] args) throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile("/Users/zhangpeng/Desktop/hello", "rw");
        FileChannel fromChannel = fromFile.getChannel();


        RandomAccessFile toFile = new RandomAccessFile("/Users/zhangpeng/Desktop/go", "rw");
        FileChannel toChannel = toFile.getChannel();

        long position = 0;
        long size = fromChannel.size();

        long transferFrom = toChannel.transferTo(position, size, fromChannel);
        System.out.println(transferFrom);


        Selector selector = Selector.open();
    }

}

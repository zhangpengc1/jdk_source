package com.marton.base.nio.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class NIOClient {

    public static final ExecutorService executorService = Executors.newFixedThreadPool(1000);


    public static void main(String[] args) throws IOException {

        final AtomicInteger atomicInteger = new AtomicInteger(0);

        for (int i = 0; i < 500; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        InetSocketAddress remote = new InetSocketAddress("127.0.0.1", 9999);
                        ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                        ByteBuffer readBuffer = ByteBuffer.allocate(1024);

                        SocketChannel channel = SocketChannel.open();
                        channel.connect(remote);
//        while (true) {
                        writeBuffer.put("this is my first!".getBytes());
                        writeBuffer.flip();
                        channel.write(writeBuffer);
                        writeBuffer.clear();

                        // read
                        int read = channel.read(readBuffer);
                        if (read == -1) {
                            return;
                        }
                        readBuffer.flip();
                        byte[] datas = new byte[readBuffer.remaining()];
                        readBuffer.get(datas);
                        System.out.println("from server:" + new String(datas, "UTF-8") + " id" + atomicInteger.addAndGet(1));
                        readBuffer.clear();
//        }
                        channel.close();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            });
        }


    }


}

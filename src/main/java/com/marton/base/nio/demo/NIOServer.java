package com.marton.base.nio.demo;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * NIO服务端
 */
public class NIOServer implements Runnable {

    // 通道管理器
    private Selector selector;
    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private ByteBuffer writeBuffer = ByteBuffer.allocate(1024);

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public NIOServer(int port) {
        init(port);
    }

    public void initServer(int port) throws IOException {
        init(port);
    }

    public void init(int port) {
        try {
            System.out.println("Server staring at port:" + port);
            // 开启多路复用器
            this.selector = Selector.open();
            // 开启服务通道
            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            serverChannel.configureBlocking(false);
            serverChannel.bind(new InetSocketAddress(port));
            serverChannel.register(this.selector, SelectionKey.OP_ACCEPT);
            System.out.println("Server started");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 采用轮询的方式监听selector上是否有需要处理的事件
     * 如果有，则进行处理
     */
    @Override
    public void run() {
        while (true) {
            try {
                this.selector.select();
                Iterator<SelectionKey> keys = this.selector.selectedKeys().iterator();
                while (keys.hasNext()) {
                    SelectionKey key = keys.next();
                    keys.remove();
                    if (key.isValid()) {
                        try {
                            if (key.isAcceptable()) {
                                accept(key);
                            }
                        } catch (CancelledKeyException cke) {
                            key.cancel();
                        }
                        try {
                            if (key.isReadable()) {
                                read(key);
                            }
                        } catch (CancelledKeyException cke) {
                            key.cancel();
                        }
                        try {
                            if (key.isWritable()) {
                                write(key);
                            }
                        } catch (CancelledKeyException cke) {
                            key.cancel();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void accept(SelectionKey key) {
        try {
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            SocketChannel channel = serverSocketChannel.accept();
            channel.configureBlocking(false);
            channel.register(this.selector, SelectionKey.OP_READ);
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }

    private void read(SelectionKey key) {
        try {
            this.readBuffer.clear();
            SocketChannel channel = (SocketChannel) key.channel();
            int readLength = channel.read(readBuffer);
            if (readLength == -1) {
                key.channel().close();
                key.cancel();
                return;
            }
            this.readBuffer.flip();
            byte[] datas = new byte[readBuffer.remaining()];
            readBuffer.get(datas);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
            System.out.println("id" + atomicInteger.addAndGet(1) + " time:" + simpleDateFormat.format(new Date()) + " From " + channel.getRemoteAddress() + "Clinet: " + new String(datas, "UTF-8"));

            channel.register(this.selector, SelectionKey.OP_WRITE);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @SuppressWarnings("resource")
    private void write(SelectionKey key) {
        this.writeBuffer.clear();
        SocketChannel channel = (SocketChannel) key.channel();
        try {
            writeBuffer.put("this is server response!".getBytes("UTF-8"));

//            try {
//                Thread.sleep(100L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            writeBuffer.flip();
            channel.write(writeBuffer);
            channel.register(this.selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 启动服务端测试
     *
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        new Thread(new NIOServer(9999)).start();
    }


}

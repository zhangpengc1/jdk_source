package com.marton.base.juc.thread; /**
 * @title: Interrupted_1
 * @projectName jdk_source
 * @description: TODO
 * @author zhangpeng
 * @date 2022/4/14  下午5:09
 */

/**
 * @author ：zhangp
 * @Date ：2022/4/14 下午5:09
 * @desc :
 */
public class Interrupted_1 {


    public static void main(String[] args) {


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    if (Thread.currentThread().isInterrupted()){
                        System.out.println("bye bye");
                        return;
                    }

                    System.out.println("1...1...1");

                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        System.out.println("eeeeeeee");
                    }
                }


            }
        });

        thread.start();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }
}

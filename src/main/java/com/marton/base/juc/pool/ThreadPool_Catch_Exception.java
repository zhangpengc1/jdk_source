package com.marton.base.juc.pool;

import java.util.concurrent.*;

/**
 * @author ：zhangp
 * @Date ：2022/4/6 下午5:53
 * @desc :
 */
public class ThreadPool_Catch_Exception {

    private static ExecutorService executorService = new ThreadPoolExecutor(5, 5,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());

    public static void main(String[] args) {


//        FutureTask<String> hello = executorService.submit(new FutureTask<>());
//
//
//        try {
//
//            String s = hello.get();
//            System.out.println(s);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }


    }


}

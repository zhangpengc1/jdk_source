package com.marton.base.juc.future;

import java.util.concurrent.*;

public class FutureTaskDemo {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        FutureTask<String> task = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {

                Thread.sleep(1);
                //System.out.println("hello");
                return "hello";
            }
        });

        Thread thread = new Thread(task);
        thread.start();

        Thread thread_1 = new Thread(new GetResultTask(task));
        thread_1.start();

        Thread thread_2 = new Thread(new GetResultTask(task));
        thread_2.start();

        Thread thread_3 = new Thread(new GetResultTask(task));
        thread_3.start();


    }



    public static class GetResultTask implements Runnable{

        private FutureTask futureTask;


        public GetResultTask(FutureTask futureTask){
            this.futureTask = futureTask;
        }

        @Override
        public void run() {

            try {
                Object o = futureTask.get();
                System.out.println(o);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }
    }


}

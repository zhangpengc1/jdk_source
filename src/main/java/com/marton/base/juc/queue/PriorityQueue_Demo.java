package com.marton.base.juc.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityQueue_Demo {

    private static BlockingQueue<MyPriorityTask> blockingQueue = new PriorityBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {
        MyPriorityTask task1 = new MyPriorityTask();
        task1.setName("zhangsan1");
        task1.setAge(1);

        MyPriorityTask task2 = new MyPriorityTask();
        task2.setName("zhangsan2");
        task2.setAge(2);

        MyPriorityTask task3 = new MyPriorityTask();
        task3.setName("zhangsan3");
        task3.setAge(3);

        blockingQueue.add(task2);
        blockingQueue.add(task1);
        blockingQueue.add(task3);
        MyPriorityTask matask;
        while ((matask = blockingQueue.take()) != null ){
            System.out.println(matask.getAge());
        }

    }


    public static class MyPriorityTask implements Comparable<MyPriorityTask> {

        private String name;

        private Integer age;

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(MyPriorityTask o) {
            return o.age - this.age;
        }
    }


}

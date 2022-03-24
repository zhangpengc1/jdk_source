package com.marton.base.juc.forkjoin;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class SumTask extends RecursiveTask<Long> {

    private static final int SEQUENTIAL_THRESHOLD = 50;

    private final List<Long> data;

    public SumTask(List<Long> data) {
        this.data = data;
    }


    @Override
    protected Long compute() {

        if (data.size() <= SEQUENTIAL_THRESHOLD){

            long sum = computeSumDirectly();
            return sum;
        }else {
            int mid = data.size() / 2;
            SumTask firstTask = new SumTask(data.subList(0,mid));
            SumTask secondTask = new SumTask(data.subList(mid,data.size()));

            // 执行子任务
            firstTask.fork();
            secondTask.fork();

            // 等待子任务执行完成，并获取结果
            Long firstTaskResult = firstTask.join();
            Long secondTaskResult = secondTask.join();

            return firstTaskResult + secondTaskResult;

        }
    }


    /**
     * 计算每个子任务的和
     *
     * @return
     */
    private long computeSumDirectly() {
        long sum = 0;
        for (Long L : data) {
            sum += L;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Random random = new Random();
        List<Long> data = random
                .longs(1_000, 1, 100)
                .boxed()
                .collect(Collectors.toList());

        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(data);
        System.out.println("Sum: " + pool.invoke(task));

    }

}

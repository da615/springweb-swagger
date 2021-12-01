package com.adam.config;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 8;
    private static final int QUEUE_CAPACITY = 10;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 40; i++) {
            Runnable worker = new MyRunnable(">>" + i);
            threadPoolExecutor.execute(worker);
            System.out.println("worker>>" + i);
        }
        //终止线程
        threadPoolExecutor.shutdown();
        while (!threadPoolExecutor.isTerminated()){

        }
        System.out.println("Finished All Threads");
    }

}

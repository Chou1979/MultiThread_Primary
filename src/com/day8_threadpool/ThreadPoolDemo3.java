package com.day8_threadpool;


import java.util.concurrent.*;

/**
 * 目标：使用Executors的工具方法直接得到一个线程池对象
 */
public class ThreadPoolDemo3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1、创建固定线程数量的线程池
        ExecutorService pool = Executors.newFixedThreadPool(3); //允许请求的任务队列长度没有限制，若长度无限大时，可能会导致内存不足

        pool.execute(new MyRunnable());
        pool.execute(new MyRunnable());
        pool.execute(new MyRunnable());
        pool.execute(new MyRunnable()); //已经没有多余线程了
    }
}

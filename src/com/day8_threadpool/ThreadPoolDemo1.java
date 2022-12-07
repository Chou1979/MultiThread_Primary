package com.day8_threadpool;


import java.util.concurrent.*;

/**
 * 目标：自定义一个线程池对象，并测试其特性
 */
public class ThreadPoolDemo1 {
    public static void main(String[] args) {
        //1、创建线程池对象
        /*public ThreadPoolExecutor(int corePoolSize,
                                    int maximumPoolSize,
                                    long keepAliveTime,
                                    TimeUnit unit,
                                    BlockingQueue<Runnable> workQueue) {
            this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
                    Executors.defaultThreadFactory(), defaultHandler);
        }*/
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3,5,
                6,TimeUnit.SECONDS,new ArrayBlockingQueue<>(5),Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        //2、给任务线程池处理
        Runnable target = new MyRunnable();
        //三个任务时，核心线程可cover
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);

        //八个线程时：三个核心线程在忙，五个线程在队列里等待
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);

        //此时创建临时线程
        pool.execute(target);
        pool.execute(target);

        //此时不创建，拒绝策略被触发
        //pool.execute(target);

        //关闭线程池（开发中一般不会使用）
        //pool.shutdownNow(); //立即关闭，即使任务没有完成，会丢失任务！
        pool.shutdown(); //等待全部任务执行完毕之后再关闭
    }
}

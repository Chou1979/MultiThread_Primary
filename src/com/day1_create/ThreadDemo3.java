package com.day1_create;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 目标：学会线程的创建方式三： 实现Callable接口，结合FutureTask完成
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        //3 创建Callable任务对象
        Callable<String> call = new MyCallable(100);
        //4 把Callable任务对象封装到FutureTask对象
        // FutureTask对象作用：1）是Runnable对象（实现了Runnable接口）；
        //                   2) 可以在线程执行完毕后通过其get方法得到线程执行完成的结果
        FutureTask<String> f1 = new FutureTask<>(call);
        //5 交给线程处理
        Thread t1 = new Thread(f1);
        //6 启动线程
        t1.start();

        Callable<String> call2 = new MyCallable(1000);
        FutureTask<String> f2 = new FutureTask<>(call2);
        //5 交给线程处理
        Thread t2 = new Thread(f2);
        //6 启动线程
        t2.start();

        try {
            //如果f1任务没有执行完毕，这里的代码会等待，直到线程1跑完才提取结果
            String rs1 = f1.get();
            System.out.println("线程1的结果： "+rs1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            //如果f2任务没有执行完毕，这里的代码会等待，直到线程1跑完才提取结果
            String rs2 = f2.get();
            System.out.println("线程2的结果： "+rs2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

/**
 * 1 定义一个任务类 实现Callable接口
 */
class MyCallable implements Callable<String>{

    private int n;

    public MyCallable(int n){
        this.n=n;
    }

    /**
     * 2 重写call方法（任务方法）
     * @return
     * @throws Exception
     */
    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum += i;
        }
        return "子线程执行结果： "+sum;
    }
}
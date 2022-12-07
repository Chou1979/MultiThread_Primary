package com.day1_create;

/**
 * 目标：学会线程的创建方式二 实现Runnable接口
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        //3 创建一个任务对象
        Runnable target = new MyRunnable();
        //把任务对象交给Thread处理
        Thread t = new Thread(target);
        t.start();

        for (int i=0;i<5;i++){
            System.out.println("主线程执行输出： "+i);
        }
    }
}

/**
 * 1 定义一个线程任务类 实现Runnable接口
 */
class MyRunnable implements Runnable{
    /**
     * 2 重写run方法
     */
    @Override
    public void run() {
        for (int i=0;i<5;i++){
            System.out.println("子线程执行输出： "+i);
        }
    }
}
package com.day1_create;

/**
 * 目标：多线程的创建方式一 继承Thread类实现
 */

public class ThreadDemo1 {

    public static void main(String[] args) {
        //3 new 一个新线程对象
        Thread t = new MyThread();
        //4. 调用start方法启动线程（执行的还是run方法）
        t.start();
        //t.run();  直接调run方法没有新起线程，必须调start方法

        //要把主线程的任务放在子线程后面，这样才能实现两个线程同时执行，放前面的话会优先执行主线程
        for (int i = 0; i < 5; i++) {
            System.out.println("主线程执行输出： " + i);
        }
    }
}

/**
 * 1.定义一个多线程类
 */
class MyThread extends Thread {
    /**
     * 2.重写run方法
     */
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程执行输出： " + i);
        }
    }
}
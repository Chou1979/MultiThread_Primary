package com.day2_api;

/**
 * 目标：线程的API
 */
public class ThreadDemo01 {
    //main方法是由主线程负责调度的
    public static void main(String[] args) {
        Thread t1 = new MyThread("1号");
        //t1.setName("1号");
        t1.start();

        Thread t2 = new MyThread("2号");
        //t2.setName("2号");
        t2.start();

        //哪个线程执行它，他就得到哪个线程对象（当前执行对象）
        Thread m = Thread.currentThread();
        System.out.println(m.getName());

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程输出："+i);
        }
    }
}

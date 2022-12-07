package com.day4_thread_synchronized_code;

public class ThreadDemo {
    public static void main(String[] args) {
        //测试线程安全问题：同步代码块后，可解决线程安全问题
        //1 定义一个线程类，创建一个共享账户对象
        Account acc = new Account("ICBC-111", 1000);

        //2 创建两个线程对象，代表小明、小红同时进来了
        new DrawThread(acc,"小明").start();
        new DrawThread(acc,"小红").start();
    }
}

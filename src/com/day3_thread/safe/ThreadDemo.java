package com.day3_thread.safe;

public class ThreadDemo {
    public static void main(String[] args) {
        //1 定义一个线程类，创建一个共享账户对象
        Account acc = new Account("ICBC-111", 1000);

        //2 创建两个线程对象，代表小明、小红同时进来了
        new DrawThread(acc,"小明").start();
        new DrawThread(acc,"小红").start();
    }
}

package com.day7_thread_comunication;

public class ThreadDemo {
    public static void main(String[] args) {
        //目标：了解线程通信流程
        //使用三个大人存钱 两个小孩取钱 模拟线程通信流程

        //1.创建账户对象，代表5个人共同操作的账户
        Account acc = new Account("ICBC-112",0);

        //2.创建3个存钱线程代表三个大人：爸爸 妈妈 姐姐
        new DepositThread(acc, "爸爸").start();
        new DepositThread(acc,"妈妈").start();
        new DepositThread(acc,"姐姐").start();

        //3.创建2个取钱线程代表2个孩子
        new DrawThread(acc, "小明").start();
        new DrawThread(acc, "小红").start();
    }
}

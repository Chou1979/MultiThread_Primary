package com.day6_thread_synchronized_lock;

/**
 * 取钱线程类
 */
public class DrawThread  extends Thread{
    //接收处理的账户对象
    private Account acc;

    public DrawThread(Account acc, String name) {
        super(name);
        this.acc = acc;
    }

    public DrawThread(Account acc){this.acc= acc;}

    @Override
    public void run(){
        acc.drawMoney(1000);
    }

}

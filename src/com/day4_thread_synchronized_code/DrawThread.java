package com.day4_thread_synchronized_code;

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
    //小明小红：acc
    public void run(){
        acc.drawMoney(1000);
    }

}

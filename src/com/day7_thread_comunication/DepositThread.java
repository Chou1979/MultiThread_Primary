package com.day7_thread_comunication;
/**
 * 取钱线程类
 */
public class DepositThread extends Thread{
    private Account acc;

    public DepositThread(Account acc, String name) {
        super(name);
        this.acc = acc;
    }

    @Override
    public void run(){
        //爸爸 妈妈 姐姐：存钱
        acc.deposit(1000);
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

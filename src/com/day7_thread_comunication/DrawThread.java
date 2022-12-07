package com.day7_thread_comunication;
/**
 * 取钱线程类
 */
public class DrawThread extends Thread{
    private Account acc;

    public DrawThread(Account acc, String name) {
        super(name);
        this.acc = acc;
    }

    @Override
    public void run(){
        //小明 小红：取钱
        while (true) {
            acc.drawMoney(1000);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

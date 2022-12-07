package com.day6_thread_synchronized_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private String cardId;
    private double money;
    //唯一锁，不可修改
    private final Lock lock = new ReentrantLock();

    public Account(){

    }

    public Account(String cardId, double money) {
        this.cardId = cardId;
        this.money = money;
    }

    /**
     * 小明，小红
     * @param drawMoney
     */
    public void drawMoney(double drawMoney) {
        //0 先获取谁来取钱，线程的名字就是人名
        String name = Thread.currentThread().getName();
        //1 判断账户余额是否充足
        //小明 小红
        lock.lock(); //上锁
        try {
            if(this.money >= drawMoney){
                //2 取钱
                System.out.println(name + "来取钱成功，吐出："+drawMoney);
                //3 更新余额
                this.money -= drawMoney;
                System.out.println(name + "取钱后剩余：" + this.money);
                //System.out.println(10 / 0);
            }else {
                //4 余额不足
                System.out.println(name+"来取钱，余额不足！");
            }
        } finally {
            lock.unlock(); //解锁
        }
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}

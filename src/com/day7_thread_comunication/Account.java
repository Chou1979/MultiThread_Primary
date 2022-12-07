package com.day7_thread_comunication;

public class Account {
    private String cardId;
    private double money;

    public Account(){

    }

    public Account(String cardId, double money) {
        this.cardId = cardId;
        this.money = money;
    }

    /**
     * 小明，小红：取钱
     * @param drawMoney
     */
    public synchronized void drawMoney(double drawMoney) {
        //0 先获取谁来取钱，线程的名字就是人名
        String name = Thread.currentThread().getName();
        //1 判断账户余额是否充足
        try {
            if(this.money >= drawMoney){
                //钱够：可取
                this.money -= drawMoney;
                System.out.println(name + "来取钱"+drawMoney + "成功！");
                //没钱了
                this.notifyAll(); //唤醒所有线程：三个大人
                this.wait(); //
            }else {
                //钱不够：不可取
                //唤醒别人，等待自己
                this.notifyAll();
                this.wait(); // 锁对象，让当前线程进入等待
                System.out.println(name+"来取钱，余额不足！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 爸爸 妈妈 姐姐：存钱
     * @param money
     */
    public synchronized void deposit(double money) {
        try {
            String name = Thread.currentThread().getName();
            if(this.money == 0){
                //没钱了：存钱
                this.money += money;
                System.out.println(name + "存钱" + money +"成功！存钱后余额是"+this.money);
                //有钱了：不用再存，唤醒别人，等待自己
                this.notifyAll();
                this.wait();
            }
        } catch (Exception e) {
            e.printStackTrace();
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

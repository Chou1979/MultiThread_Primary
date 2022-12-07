package com.day4_thread_synchronized_code;

public class Account {
    private String cardId;
    private double money;

    public Account(){

    }

    public Account(String cardId, double money) {
        this.cardId = cardId;
        this.money = money;
    }

    //静态方法用字节码（类名.class）对象上锁
    // 100个线程
    public static void run(){
        synchronized (Account.class){

        }
    }

    // 实例方法用this作为锁对象
    /**
     * 小明，小红
     * this = acc
     * @param drawMoney
     */
    public void drawMoney(double drawMoney) {
        //0 先获取谁来取钱，线程的名字就是人名
        String name = Thread.currentThread().getName();
        //1 判断账户余额是否充足
        /**
         * 同步代码块 加锁(快捷键：optional + command + t)
         * 锁对象：
         * 1）任意唯一对象，例如一个字符串常量，缺点是会影响其他无关线程的运行
         * 2）对于实例方法：建议使用this作为锁对象
         */
        //synchronized ("session") {
        synchronized (this){
            if(this.money >= drawMoney){
                //2 取钱
                System.out.println(name + "来取钱成功，吐出："+drawMoney);
                //3 更新余额
                this.money -= drawMoney;
                System.out.println(name + "取钱后剩余：" + this.money);
            }else {
                //4 余额不足
                System.out.println(name+"来取钱，余额不足！");
            }
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

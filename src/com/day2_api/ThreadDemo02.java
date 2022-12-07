package com.day2_api;

/**
 * 目标：线程的API
 */
public class ThreadDemo02 {
    //main方法是由主线程负责调度的
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("输出："+i);
            if(i ==3){
                try {
                    //让当前线程进入休眠状态
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

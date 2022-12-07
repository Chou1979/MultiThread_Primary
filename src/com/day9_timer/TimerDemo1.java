package com.day9_timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer定时器的使用和了解
 */
public class TimerDemo1 {
    public static void main(String[] args) {
        //1.创建Timer定时器
        Timer timer = new Timer(); //定时器本身就是一个单线程
        //2.调用方法，处理定时任务
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行AAA一次" + new Date());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },3000,2000);

        //由于是单线程，某个任务异常时，若不处理会导致timer线程死掉，影响后续任务执行
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行BBB一次" + new Date());
                System.out.println(10/0);
            }
        },3000,2000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行CCC一次" + new Date());
            }
        },0,2000);
    }
}

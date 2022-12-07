package com.day1_create;

/**
 * 目标：学会线程的创建方式二(匿名内部类) 实现Runnable接口
 */
public class ThreadDemo2_Other {
    public static void main(String[] args) {
        //3 创建一个任务对象
        //匿名内部类写法1：最繁琐
        Runnable target = new Runnable(){
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    System.out.println("子线程1执行输出： "+i);
                }
            }
        };
        //把任务对象交给Thread处理
        Thread t = new Thread(target);
        t.start();

        //匿名内部类写法2
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){
                    System.out.println("子线程2执行输出： "+i);
                }
            }
        }).start();

        //匿名内部类写法3：函数式编程
        new Thread(() -> {
            for (int i=0;i<5;i++){
                System.out.println("子线程3执行输出： "+i);
            }
        }).start();

        for (int i=0;i<5;i++){
            System.out.println("主线程执行输出： "+i);
        }
    }

}
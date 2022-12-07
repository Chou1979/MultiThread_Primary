package com.day8_threadpool;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    private int n;
    public MyCallable(int n){
        this.n = n;
    }

    /**
     * 重写call方法
     */
    @Override
    public String call() throws Exception{
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return Thread.currentThread().getName()+"执行1-"+n+"的和"+"线程执行结果是：" + sum;
    }
}
 
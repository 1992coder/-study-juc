package com.qingqing.juc;

import java.util.concurrent.TimeUnit;

/**
 * 程序在执行过程中遇到异常，默认会释放锁
 * 并发处理中，有异常要特别注意，不然会出现不一致的情况
 * 比如，在一个web app处理过程中，多个servlet线程共同访问同一个资源，这时如果异常处理不合适，
 * 在第一个线程中抛出异常，其他线程就会进入同步代码区，有可能会访问到异常产生时的数据。
 * 因此要非常小心的处理同步业务逻辑中的异常
 */
public class Demo6 {

    int n = 0 ;

    public void m(){
        System.out.println(Thread.currentThread().getName()+" start");
        while(true){
            n++;
            System.out.println(Thread.currentThread().getName()+" n="+n);

            if(n==10){
                int i = n/0;//此处抛出异常，锁被释放。如果需求锁不被释放，这里可以进行捕获异常，让循环继续
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Demo6 demo6 = new Demo6();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                demo6.m();
            }
        };

        new Thread(r,"task1").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r,"task2").start();

    }
}

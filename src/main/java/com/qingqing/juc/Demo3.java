package com.qingqing.juc;

/**
 * 同步和非同步方法能否同步调用?
 * 实验结果：可以同步调用
 */
public class Demo3 {

    public synchronized void  m1(){
        System.out.println(Thread.currentThread().getName()+" m1 start");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" m1 end");
    }

    public void m2(){
        System.out.println(Thread.currentThread().getName()+" m2 start");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" m2 end");
    }

    public static void main(String[] args) {
        Demo3 demo3 = new Demo3();

        new Thread(()->demo3.m1()).start();
        new Thread(()->demo3.m2()).start();

    }
}

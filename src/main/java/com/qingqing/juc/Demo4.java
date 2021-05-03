package com.qingqing.juc;

import java.util.concurrent.TimeUnit;

/**
 * 一个方法调用另外一个同步方法，一个线程已经拥有某个对象的锁，再次申请的时候仍然会得到
 * 该对象的锁，说明synchronized是可重入锁
 */
public class Demo4 {

    synchronized void m1(){
        System.out.println(" m1 start");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" m1 end");
        m2();
    }

    synchronized void m2(){
        System.out.println("m2 start");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2 end");
    }

    public static void main(String[] args) {
        new Demo4().m1();
    }
}

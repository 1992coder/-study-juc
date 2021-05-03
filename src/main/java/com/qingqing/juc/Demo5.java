package com.qingqing.juc;

import java.util.concurrent.TimeUnit;

/**
 * 一个同步方法可以调用另外一个同步方法，一个线程已经拥有某个对象的锁，
 * 再次申请的时候仍然会得到该对象的锁.也就是说synchronized获得的锁是可重入的
 * 继承中：子类调用父类的同步方法，同步锁锁住的是子类对象
 */
public class Demo5 {
    synchronized void m() {
        System.out.println("m start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        new Demo().m();
    }

}
    class Demo extends Demo5{
        synchronized void m() {
            System.out.println("son start");
            super.m();
            System.out.println("son end");
        }
    }




package com.qingqing.juc;

public class Demo2 {

    public static int n = 10;
    public static synchronized void m(){//等同于方法中的代码块synchronized(this)
        n--;
        System.out.println(Thread.currentThread().getName()+":n="+n);
    }

    public  static void mm(){
        synchronized (Demo2.class){//考虑一下这里写synchronized(this)是否可以？不能，这里是对类对象进行加锁
            n++;
        }
    }

    public static void main(String[] args) {
        m();
        mm();
    }
}

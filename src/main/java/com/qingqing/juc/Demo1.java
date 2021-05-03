package com.qingqing.juc;

/**
 * synchronized
 */
public class Demo1 {
    public int n = 10;

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        demo1.m();
        demo1.n();
    }

    public synchronized void m(){//等同于方法中的代码块synchronized(this)
        n--;
        System.out.println("调用n方法"+":n="+n);
    }

    public void n(){//访问这个方法时不需要加锁
        n++;
        System.out.println("调用n方法"+":n="+n);
    }

}

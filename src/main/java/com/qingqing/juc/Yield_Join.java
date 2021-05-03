package com.qingqing.juc;

/**
 * 用于测试yield和join
 * yield : 让出时间片，让线程回到ready状态,再次进入到等待队列中
 * join:b中调用了a线程的join，则测试b处于阻塞状态
 *
 */
public class Yield_Join {
    public static void main(String[] args) {
//        testYield();
        testJoin();
    }

    static void testYield(){
        new Thread(()->{
            for(int i=0;i<100;i++){
                System.out.println("-------A"+i);
                if(i%10==0)Thread.yield();
            }
        }).start();

        new Thread(()->{
            for(int i=0;i<100;i++){
                System.out.println("-------B"+i);
                if(i%10==0)Thread.yield();
            }
        }).start();
    }

    static void testJoin(){
        Thread t1 = new Thread(()->{
            for(int i=0;i<100;i++){
                System.out.println("-------A"+i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i=0;i<100;i++){
                System.out.println("-------B"+i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}

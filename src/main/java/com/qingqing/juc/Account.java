package com.qingqing.juc;

import java.util.concurrent.TimeUnit;

/**
 * 加了重量级锁之后-模拟出现dirty read情况
 */
public class Account {

    public String name;

    public double balance;

    public void setAccount(String name,double balance){
        this.name = name;
        try {
//            Thread.sleep(2000);
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public void  getBalance(){
        System.out.println(balance);
    }

    public static void main(String[] args) {
        Account account = new Account();
        new Thread(()->{
            account.setAccount("lisi",100);
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        account.getBalance();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.getBalance();

    }
}

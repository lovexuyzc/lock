package com.atguigu.lock;

import java.util.concurrent.TimeUnit;

/**
 * @outhor shkstart
 * @create 2019-08-27 14:28
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA="lockA";
        String lockB="lockB";

         new Thread(
            new HoldLockThread(lockA,lockB)
          ,"AAA").start();
        new Thread(
            new HoldLockThread(lockB,lockA),
       "BBB").start();

    }

}
class HoldLockThread implements Runnable{
    private String LockA;
    private String LockB;

    public HoldLockThread(String lockA, String lockB) {
        LockA = lockA;
        LockB = lockB;
    }

    @Override
    public void run() {
    synchronized (LockA){
        System.out.println(Thread.currentThread().getName()+"自己持有"+LockA+"尝试获得B");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (LockB) {
            System.out.println(Thread.currentThread().getName() + "自己持有" + LockB + "尝试获得A");
        }

    }
    }
}

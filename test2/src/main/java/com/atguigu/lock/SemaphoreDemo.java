package com.atguigu.lock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @outhor shkstart
 * @create 2019-08-23 16:02
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        java.util.concurrent.Semaphore semaphore=new java.util.concurrent.Semaphore(3);//3个停车位

        for (int i = 0; i <6 ; i++) {
            final int temp=i;
            new Thread(()->{
                try {
                    semaphore.acquire();//抢资源
                    System.out.println(Thread.currentThread().getName()+"抢到"+temp+"停车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("3秒后离开");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();//释放资源
                }
            },String.valueOf(i)).start();

        }

    }

}

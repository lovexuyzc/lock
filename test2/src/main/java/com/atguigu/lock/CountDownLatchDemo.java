package com.atguigu.lock;

import java.sql.SQLOutput;
import java.util.concurrent.CountDownLatch;

/**
 * @outhor shkstart 减
 * @create 2019-08-23 16:22
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch=new CountDownLatch(7);
         for (int i = 0; i <6 ; i++) {
                     new Thread(()->{
                         System.out.println(Thread.currentThread().getName());
                         countDownLatch.countDown();
                     },String.valueOf(i)).start();

                 }
        try {
            countDownLatch.await();
            System.out.println("轮到我了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

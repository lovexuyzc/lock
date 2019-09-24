package com.atguigu.lock;

import com.atguigu.Interview.Enums;

import java.sql.SQLOutput;
import java.util.concurrent.CountDownLatch;

/**
 * @outhor shkstart 减
 * @create 2019-08-23 16:22
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {

        CountDownLatch countDownLatch=new CountDownLatch(4);
         for (int i = 0; i <4; i++) {
                     new Thread(()->{
                         System.out.println(Thread.currentThread().getName());
                         countDownLatch.countDown();
                     }, Enums.forEach_Enum(i+1).getRetMessage()).start();

                 }
        try {
            countDownLatch.await();
            System.out.println("轮到我了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

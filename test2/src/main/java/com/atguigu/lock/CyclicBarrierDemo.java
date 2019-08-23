package com.atguigu.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @outhor shkstart
 * @create 2019-08-23 16:25
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(7,()->{
            System.out.println("召唤神龙");
        });
         for (int i = 0; i <7 ; i++) {

                     new Thread(()->{
                         System.out.println(Thread.currentThread().getName()+"收集龙珠");
                         try {
                             cyclicBarrier.await();
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         } catch (BrokenBarrierException e) {
                             e.printStackTrace();
                         }
                     },String.valueOf(i)).start();

                 }
    }
}

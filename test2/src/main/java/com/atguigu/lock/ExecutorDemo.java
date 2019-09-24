package com.atguigu.lock;

import java.util.concurrent.*;

/**
 * @outhor shkstart
 * @create 2019-08-27 9:30
 */
public class ExecutorDemo {



    public static void main(String[] args) throws Exception{
       // ExecutorService threadPool=Executors.newFixedThreadPool(5);//固定个数的线程池
        //  ExecutorService threadPool=Executors.newSingleThreadExecutor();//单个线程池
      ExecutorService threadPool=Executors.newCachedThreadPool();//执行很多线程池自适应
                MCallable mCallable=  new MCallable();

      //  Future<Integer> submit = threadPool.submit(mCallable);
        for (int i = 0; i <20 ; i++) {
            threadPool.execute(()->{
                System.out.println(Thread.currentThread().getName());
            });

        }

      //      System.out.println(submit.get());
            threadPool.shutdown();


    }
}

package com.atguigu.lock;

import com.itextpdf.text.log.SysoCounter;
import sun.nio.ch.ThreadPool;

import java.security.SecureRandom;
import java.util.concurrent.*;

/**
 * @outhor shkstart
 * @create 2019-08-27 12:23
 */
public class ExecutorDemo2 {
    public static void main(String[] args) {
        ExecutorService threadPool=new ThreadPoolExecutor(
                2,
                5,
                1,
                TimeUnit.SECONDS,new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        try {
            for (int i = 0; i <10 ; i++) {
                threadPool.execute(() ->{
                    System.out.println(Thread.currentThread().getName()+"办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
     
    }
}

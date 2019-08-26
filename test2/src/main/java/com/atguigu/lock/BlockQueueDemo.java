package com.atguigu.lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @outhor shkstart
 * @create 2019-08-26 13:37
 */
public class BlockQueueDemo {
    public static void main(String[] args) {
        MyResource myResource=new MyResource(new ArrayBlockingQueue<>(20));

                     new Thread(()->{
                         System.out.println(Thread.currentThread().getName()+"生产启动");
                         try {
                            myResource.myProd();
                         }catch (Exception e){
                             e.printStackTrace();
                         }
                     },"prod").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"消费启动");
            try {
                myResource.myConsumer();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"consumer").start();
        try {
            TimeUnit.SECONDS.sleep(5);
            myResource.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
class MyResource{
    private  volatile boolean FLAG=true;//线程开关状态
    private AtomicInteger atomicInteger=new AtomicInteger();//原子类型Intger
    BlockingQueue<String> blockingQueue=null;//队列阻塞

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd()throws Exception{
        String data=null;
        Boolean reValue;

        while (FLAG){
            data=atomicInteger.incrementAndGet()+"";

          reValue=  blockingQueue.offer(data,2L,TimeUnit.SECONDS);
        if (reValue){

            System.out.println(Thread.currentThread().getName()+data+"成功");
        }else {
            System.out.println(Thread.currentThread().getName()+data+"失败");
        }
       TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("结束");
    }

    public void myConsumer()throws Exception{
        String result=null;
        while (FLAG){

            result= blockingQueue.poll(2L,TimeUnit.SECONDS);
            if(null==result||result.equalsIgnoreCase("")){
                FLAG=false;
                System.out.println(Thread.currentThread().getName()+"超过2秒没有取到蛋糕消费退出");
                return;
            }

            System.out.println(Thread.currentThread().getName()+"消费"+result+"成功");
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public void stop() throws Exception{
        this.FLAG=false;
    }
}
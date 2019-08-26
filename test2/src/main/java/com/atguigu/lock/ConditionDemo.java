package com.atguigu.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @outhor shkstart
 * @create 2019-08-26 11:35
 */
public class ConditionDemo {
    public static void main(String[] args) {

        Singal singal=new Singal();
         for (int i = 0; i <10 ; i++) {
                     new Thread(()->{
                            singal.print5();
                     },"A").start();

                 }
    }

}



    class  Singal{
        Lock lock=new ReentrantLock();
        private Condition c1=lock.newCondition();
        private Condition c2=lock.newCondition();
        private Condition c3=lock.newCondition();
        private int number=1;
        public void  print5(){

            try{
                lock.lock();
                Thread.currentThread().setName("A");

                while (number!=1){
                    c1.await();
                }
                for (int i =1; i <=5 ; i++) {
                    System.out.println(Thread.currentThread().getName()+""+i);
                }
                number=2;
                Thread.currentThread().setName("B");
                c2.signal();
                while (number!=2){
                    c2.await();
                }
                for (int i = 1; i <=10 ; i++) {
                    System.out.println(Thread.currentThread().getName()+""+i);
                }
                number=3;
                Thread.currentThread().setName("C");
                c3.signal();
                while (number!=3){
                    c3.await();
                }
                for (int i = 1; i <=15 ; i++) {
                    System.out.println(Thread.currentThread().getName()+""+i);
                }
                number=1;
                c1.signal();
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        }
    }
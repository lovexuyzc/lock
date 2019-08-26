package com.atguigu.exer;

import sun.applet.Main;
import sun.security.provider.PolicySpiFile;

import java.security.PrivateKey;
import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test2 {
     AtomicReference<Thread> atomicReference=new AtomicReference();
     ReentrantReadWriteLock rt=new ReentrantReadWriteLock();

     @org.junit.Test
    public void test9() {
        Lock lock=new ReentrantLock();
         Condition condition =lock.newCondition();
        try{
            lock.lock();
            condition.await(5,TimeUnit.SECONDS);

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }

    }
    public void myLock(){
        rt.writeLock().lock();

        Thread thread =Thread.currentThread();
        while (!atomicReference.compareAndSet(null,thread)){
            TimeUnit.MILLISECONDS.toMinutes(5);
        }
        rt.writeLock().unlock();
    }
    public void myunLock(){
        Thread thread =Thread.currentThread();

        while (!atomicReference.compareAndSet(thread,null)){

        }
    }
}

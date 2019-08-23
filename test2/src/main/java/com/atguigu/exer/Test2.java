package com.atguigu.exer;

import sun.applet.Main;
import sun.security.provider.PolicySpiFile;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test2 {
     AtomicReference<Thread> atomicReference=new AtomicReference();
     ReentrantReadWriteLock rt=new ReentrantReadWriteLock();

     @org.junit.Test
    public void test9() {


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

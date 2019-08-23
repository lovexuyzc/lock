package com.atguigu.exer;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CallableService implements Callable

{
    private Lock lock = new ReentrantLock();
    @Override
    public  Integer call() throws Exception {

        lock.lock();
        System.out.println("子线程在进行计算");

        int sum = 0;
        for(int i=0;i<100;i++)
            sum += i;
        lock.unlock();
        return sum;
    }
}

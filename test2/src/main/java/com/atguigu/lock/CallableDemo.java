package com.atguigu.lock;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @outhor shkstart
 * @create 2019-08-26 16:38
 */
public class CallableDemo {
    public static void main(String[] args) {

        MCallable mCallable=new MCallable();
        FutureTask futureTask=new FutureTask(mCallable);
        Thread thread=new Thread(futureTask,"aa");
        thread.start();
        try {
            while (!futureTask.isDone()){
                //do something
            }
            System.out.println( futureTask.get());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
class MCallable implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        return 11;
    }
}
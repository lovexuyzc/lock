package com.atguigu.exer;


public class Instance {
    private  static  volatile   Instance instance=null;

    private Instance() {
        System.out.println(Thread.currentThread().getName()+"加载初始化方法");
    }

    public static  Instance getInstance(){
        if (instance==null){
            synchronized (Instance.class){
                if (instance==null) {
                    instance = new Instance();
                }
            }
        }
        return instance;
    }
}

package com.atguigu.exer;

import com.atguigu.java8.Employee;
import com.atguigu.java8.MyFun;
import com.sun.corba.se.impl.orbutil.closure.Future;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
    List<Employee> pList = Arrays.asList(

            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );
    final float i=3.14f;
    public static void main(String[] args) {
/*   List<Employee> emps = Arrays.asList(

                new Employee(101, "张三", 18, 9999.99),
                new Employee(102, "李四", 59, 6666.66),
                new Employee(103, "王五", 28, 3333.33),
                new Employee(104, "赵六", 8, 7777.77),
                new Employee(105, "田七", 38, 5555.55)
        );
        DoubleSummaryStatistics collect = emps.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(collect.getAverage()+"//"+collect.getMax());
           // emps.forEach(System.out::println);
        emps.forEach(t->System.out.println("集合元素是："+emps));*/

    }


    @org.junit.Test
    public void list2() {



   /*     System.out.println("未做过滤:" + pList);
        List<Employee> collects = pList.stream().filter(employee -> employee.getAge()>29).collect(Collectors.toList());
        System.out.println("做了过滤:" + collects);
*/
        List a = pList.stream().map(employee -> new Employee(employee.getId(), employee.getName(), employee.getAge(), employee.getSalary() + 100)).collect(Collectors.toList());

        System.out.println(a);
        System.out.println(pList);
    }


    @org.junit.Test
    public void test6() {
        //创建线程池
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1= (ThreadPoolExecutor) executorService;

        //配置线程池

        //在线程池中创建callable待返回的线程
        java.util.concurrent.Future future = executorService.submit(new CallableService());
        //executorService.execute();实现runnable线程接口
        //关闭线程池
        executorService.shutdown();
        //获取callable返回的线程的值转换
        try {
        Integer o = (Integer) future.get();

            System.out.println(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //使用callable创建线程
     /*   CallableService  callableService=new CallableService();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(callableService);
        new Thread(futureTask).start();
        try {
            Integer integer = futureTask.get();
            System.out.println(integer);

        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }
    @org.junit.Test
    public void test7() {
/*        Instance instance=new Instance();
       Employee employee;
        employee = instance.getInstance(new Employee());
        System.out.println(employee);*/
        byte b = (byte)129;
        System.out.println(b);
    }


    @org.junit.Test
    public void test8() {
        for(int i=1;i<=10;i++){
            new Thread(()->{
                Instance.getInstance();
            },String.valueOf(i)).start();
        }
    }

    @org.junit.Test
    public void test9() {
        Thread thread =Thread.currentThread();
        Thread thread1=new Thread();
        System.out.println(thread+"============="+thread1);
    }
}
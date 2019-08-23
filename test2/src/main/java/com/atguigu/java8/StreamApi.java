package com.atguigu.java8;

import java.util.stream.Stream;

public class StreamApi {
    public static void main(String[] args) {
        Stream stream= Stream.iterate(0,(x)->x+2);
        stream.limit(10).forEach(System.out::println);
        stream.close();

        Stream.generate(()->(double)(Math.random()))
                .limit(5).forEach(System.out::println);
    }
}

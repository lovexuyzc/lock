package com.atguigu.exer;

import java.awt.*;

/**
 * @outhor shkstart
 * @create 2019-08-26 17:19
 */
public class Test3 {
    public static void main(String[] args) {
      for (int i = 0; i <6 ; i++) {
                  new Thread(()->{

                  },String.valueOf(i)).start();

              }


    }
}

package com.atguigu.Interview;

import lombok.Getter;


/**
 * @outhor shkstart
 * @create 2019-09-24 9:29
 */
public enum Enums {
    ONE(1,"鸡腿"),TWO(2,"汉堡"),THREE(3,"可乐"),FOUR(4,"薯条");

     private Integer retcode;
     private String retMessage;

    public Integer getRetcode() {
        return retcode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    Enums(Integer retcode, String retMessage) {
        this.retcode = retcode;
        this.retMessage = retMessage;
    }
    public static Enums forEach_Enum(int index){
        Enums[] array=Enums.values();
        for (Enums enums: array){
            if (index==enums.getRetcode()){
                return enums;
            }
        }
        return null;
    }
}

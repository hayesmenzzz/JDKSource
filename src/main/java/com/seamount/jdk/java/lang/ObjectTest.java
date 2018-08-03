package com.seamount.jdk.java.lang;

import com.seamount.jdk.entity.Parent;
import com.seamount.jdk.entity.Son;
import org.junit.Test;

public class ObjectTest {

    @Test
    public void getClassTest(){
        Parent p = new Son();
        System.out.println(p.getClass());
        System.out.println(Parent.class);
        System.out.println("--------------------");

        //类型为T的变量 getclass方法返回值类型其实是 Class<? extemnd T> 而非 Class<T>
        Class<? extends String> clazz = "".getClass();
        System.out.println(clazz);
    }


    /**
     * hashCode() 方法在Object也是用nativ声明的一个本地方法，作用是返回对象的散列码，是int类型的数值
     */
    @Test
    public void hashCodeTest(){
        //在JDK的Integer类，Float类，String类等都重写了hashCode方法

    }
}

package com.seamount.jdk.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LambdaTest {

    @Test
    public void oldRunable() throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("The old runable now is using!");
            }
        }).start();
        Thread.sleep(1000);
    }

    /**
     * 使用lambda替代匿名内部类
     * lambda表达式用得最多的场合就是替代匿名内部类
     * lambda表达式的功能相当强大，用()->就可以代替整个匿名内部类
     */
    @Test
    public void  annoymousInnerClassTest() throws InterruptedException {
        new Thread(()-> System.out.println(" It's a lambda function!")).start();
        Thread.sleep(1000);
    }

    /**
     * 多个表达式的时候可以用大括号包括起来
     * @throws InterruptedException
     */
    @Test
    public void  annoymousInnerClassTest2() throws InterruptedException {
        new Thread(()-> {
            System.out.println(" It's a lambda function! (1)");
            System.out.println(" It's a lambda function! (2)");
        }).start();
        Thread.sleep(1000);
    }



    /**
     * 使用lambda表达式对集合进行迭代
     */
    @Test
    public void lambadaIterationTest(){
        String[] a = {"a", "b", "c"};
        List<String> strings = Arrays.asList(a);
        System.out.println("---------------------before java8---------------------");
        for (String each : strings) {
            System.out.println(each);
        }
        System.out.println("---------------------after java8---------------------");
        strings.forEach(System.out::println);
        System.out.println("---");
        strings.forEach(e -> System.out.println(e));
    }
}

package com.seamount.jdk.java.lang;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

public class StringTest {
    public static void main(String[] args) {
        String a = "AAA";
        String b = "AAA";

        System.out.println(a.equals(b));
    }

    @Test
    public void splitTest(){
        String str = "a,b,c";
        String[] c1 = str.split(",", 2);
        System.out.println(c1.length);
        System.out.println(Arrays.toString(c1));

        System.out.println("------------------------------------------");
        String str2 = "a,b,c,,";
        String[] c2 = str2.split(",", 0);
        System.out.println(c2.length);
        System.out.println(Arrays.toString(c2));

        System.out.println("------------------------------------------");

    }

    @Test
    public void equalsTest(){
        String str1 = "hello";
        String str2 = "hello";
        String str3 = new String("hello");
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str2 == str3);
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));
        System.out.println(str2.equals(str3));

    }

    @Test
    public void equals1Test(){
        System.out.println("----------------------------------------");
        System.out.println("使用包含变量表达式创建对象");
        String str1 = "helllo";
        String str2 = "helloworld";
        String str3 = str1 + "world";
        String str4 = "hello" + "world";
        System.out.println(str2 == str3);
        System.out.println(str2 == str4);
        System.out.println(str3 == str4);

    }

    /**
     * 就是说调用一个String对象的intern()方法，如果常量池中有该对象了，
     * 直接返回该字符串的引用（存在堆中就返回堆中，存在池中就返回池中），
     * 如果没有，则将该对象添加到池中，并返回池中的引用。
     */
    @Test
    public void innerTest(){
        String str1 = "hello";
        String str2 = str1.intern();
        System.out.println(str1 == str2);

        //调用new出来的在堆中的变量的inner方法时候，会把该变量添加到常量池中并返回指向常量池的引用
        // 故为false
        String str3 = new String("world");
        String str4 = str3.intern();
        System.out.println(str3 == str4);

        String str5 = str1 + str2;
        String str6 = str5.intern();
        System.out.println(str5 == str6);

        String str7 = "hello" + "world";
        String str8 = str7.intern();
        System.out.println(str7 == str8);
    }

    @Test
    public void finalTest() throws NoSuchFieldException, IllegalAccessException {
        String str = "vae";
        System.out.println(str);
        Field fieldStr = String.class.getDeclaredField("value");
        //因为value是private修饰的，这里修改其访问权限
        fieldStr.setAccessible(true);
        //获取str对象上的value属性
        char[] value = (char[]) fieldStr.get(str);
        //将第一个小v修改为大V
        value[0] = 'V';
        //打印修改后的字符串
        System.out.println(str);
    }

















}

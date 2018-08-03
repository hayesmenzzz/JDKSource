package com.seamount.jdk.java.lang;

import java.util.HashMap;
import java.util.Map;

public class HashCodeTest {

    String name;

    public HashCodeTest(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Map<HashCodeTest, String> map = new HashMap<>(4);
        map.put(new HashCodeTest("hello"), "hello");
        String hello = map.get(new HashCodeTest("hello"));
        System.out.println(hello);
        // 因为我们没有重写hashcode方法 所有 hashMap内部使用的是该对象的内存地址 ，那么key是肯定不一样的
        // 而我们经常把string 作为key 因为string重写了hashcode方法
        // string使用char数组的数字每次乘以31在叠加最后返回，因此每个不同的字符串 返回的 hashcode 肯定不一样
    }
}

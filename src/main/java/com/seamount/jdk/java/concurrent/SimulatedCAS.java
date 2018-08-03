package com.seamount.jdk.java.concurrent;

/**
 * CAS被称为无锁定算法，其实就是不使用同步的一些锁，尽量使得线程执行的流畅，每个线程可以独立完成自己的特定工作
 * 它工作的时候先从地址V获取值A，然后自己计算完毕得到一个新值B，更新的时候如果从原始地址得到的值A没有改变，那么就将A值改为B值
 */
public class SimulatedCAS {

    private int value;

    public synchronized int getValue(){
        return value;
    }

    public synchronized int compareAndSwap(int expectedValue, int newValue) {

        if (value == expectedValue){
            value = newValue;
        }
        return value;
    }
}

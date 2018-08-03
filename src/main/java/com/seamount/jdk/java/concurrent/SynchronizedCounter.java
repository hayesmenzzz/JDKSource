package com.seamount.jdk.java.concurrent;

/**
 * 索同步算法实现的计数器,使用synchrozied修饰保证操作的原子性，但是在竞争激烈的时候将大大损耗性能，因为jvm用了更多的时间来调度线程，管理和等待线程队列
 * 而实际工作 计算 的时间却很少
 */
public class SynchronizedCounter {

    private int value;

    public synchronized int getValue(){
        return value;
    }

    public synchronized int increament(){
        return ++value;
    }

    public synchronized  int decreament(){
        return --value;
    }

}

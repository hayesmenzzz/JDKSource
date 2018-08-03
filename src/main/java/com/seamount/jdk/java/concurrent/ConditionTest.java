package com.seamount.jdk.java.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    public static void main(String[] args) {
        // 创建并发访问的账户
        MyCount myCount = new MyCount("95599200901215522", 10000);
        //创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Thread t1 = new SaveThread("张三", myCount, 1000);
        Thread t2 = new SaveThread("李四", myCount, 1000);
        Thread t3 = new DrawThread("王五", myCount, 12600);
        Thread t4 = new SaveThread("老张", myCount, 600);
        Thread t5 = new DrawThread("老牛", myCount, 1300);
        Thread t6 = new DrawThread("胖子", myCount, 800);
        Thread t7 = new SaveThread("测试", myCount, 2100);
        // 执行各个线程
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        pool.execute(t6);
        pool.execute(t7);
        // 关闭线程池
        pool.shutdown();
    }



    /**
     * 存款线程类
     */
    static class SaveThread extends Thread {
        private String name; // 操作人
        private MyCount myCount; // 账户
        private int x; // 存款金额

        public SaveThread(String name, MyCount myCount, int x) {
            this.name = name;
            this.myCount = myCount;
            this.x = x;
        }

        @Override
        public void run() {
            myCount.saving(x, name);
        }
    }

    /**
     * 取款线程类
     */
    static class DrawThread extends Thread{
        private String name; // 操作人
        private MyCount myCount; // 账户
        private int x; // 存款金额

        DrawThread(String name, MyCount myCount, int x) {
            this.name = name;
            this.myCount = myCount;
            this.x = x;
        }

        public void run() {
            myCount.drawing(x, name);
        }
    }
























}


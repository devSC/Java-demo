package com.wilson;
//package java.lang.*;


/**
 *
 * http://www.runoob.com/java/java-multithreading.html
 *
 * 创建线程的三种方式的对比
 * 1. 采用实现 Runnable、Callable 接口的方式创见多线程时，线程类只是实现了 Runnable 接口或 Callable 接口，还可以继承其他类。
 * 2. 使用继承 Thread 类的方式创建多线程时，编写简单，如果需要访问当前线程，则无需使用 Thread.currentThread() 方法，直接使用 this 即可获得当前线程。
 *
 *
 * 上下文切开销很大, 所以不能创建太多线程.
 */

class RunnableDemo implements Runnable {

    private Thread t;
    private String threadName;

    RunnableDemo(String name) {
        threadName = name;
        println("Creating " +  threadName);
    }

    @Override
    public void run() {
        println("Running " + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            println("Thread " +  threadName + " interrupted.");
        }
        println("Thread " +  threadName + " exiting.");
    }

    public void start() {
        println("Starting " +  threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    static <T> void println(T t) {
        System.out.println(t);
    }
}

public class ThreadDemo {
    public static void test() {
        RunnableDemo r1 = new RunnableDemo("Thread-1");
        r1.start();
        RunnableDemo r2 = new RunnableDemo("Thread-2");
        r2.start();

    }
}

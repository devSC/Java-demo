package com.spark;

public class Telephone {

    //定义 成员 属性
    public float screen;
    public float cpu;
    public float memory;

    //属性默认是私有的
    float blueTooth;

    //私有属性
    float spark;


    //定义方法


    public void setScreen(float screen) {
        //this 相当于 self
        this.screen = screen;
    }

    public float getScreen() {
        return screen;
    }

    //无参构造函数
    public Telephone() {
        System.out.println("com.spark 无参数的构造方法执行了");
    }

    //有参构造函数
    public Telephone(float newScreen, float newCpu, float newMemory) {
        //初始值

        if (newScreen < 3.5f) {
            screen = 3.5f;
        }
        else {
            screen = newScreen;
        }

        screen = newScreen;
        cpu = newCpu;
        memory = newMemory;
        System.out.println("有参数的构造方法执行了");
    }


    //无返回值，无参数的方法 外部可用的公有方法
    public void call() {
        System.out.println("Telephone 有打电话的功能");
    }

    //
    public void sendMessage() {
        System.out.println("Telephone 有发短信的功能");
    }
}

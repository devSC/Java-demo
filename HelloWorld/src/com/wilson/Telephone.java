package com.wilson;

//final 修饰类是不允许继承的
//final public class Telephone {
public class Telephone {
    //定义 成员 属性
    public float screen;
    public float cpu;
    public float memory;

    //属性默认是私有的
    float blueTooth;

    //私有属性
    float spark;


    //final修饰属性， 则此属性为常量
    final float picture = 10;

    //定义方法

    //无参构造函数
    public Telephone() {
        System.out.println("无参数的构造方法执行了");
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        //判断类型
        if (getClass() != obj.getClass()) {
            return false;
        }
        Telephone tel = (Telephone)obj;
        //比较属性值
        if (screen != tel.screen) {
            return false;
        }
        return true;

    }
}

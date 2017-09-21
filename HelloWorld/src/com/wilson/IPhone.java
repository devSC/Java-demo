package com.wilson;

//继承通过 extends 来完成
public class IPhone extends Telephone {

    public IPhone() {
        //先执行父类构造方法
        super(); //默认是隐式调用的， 如果显示调用，则必须放到构造方法第一行

        //再执行子类构造方法
        System.out.println("initial IPhone");
    }


    @Override
    public void sendMessage() {

        //调用父类方法
        //super.sendMessage();

        System.out.println("send message from iPhone");
    }
}

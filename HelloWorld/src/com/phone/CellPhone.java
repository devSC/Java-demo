package com.phone;

public class CellPhone extends Telephone {
    @Override
    public void call() {
        System.out.println("通过键盘打电话");
    }

    @Override
    public void message() {
        System.out.println("通过键盘发短信");
    }
}

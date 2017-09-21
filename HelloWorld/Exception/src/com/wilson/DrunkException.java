package com.wilson;

//自定义异常
public class DrunkException extends Exception {

    public DrunkException() {

    }


    public DrunkException(String message) {
        super(message);
    }

}

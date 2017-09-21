package com.phone;

import com.interfaceDemo.IPlayGame;

public class SmartPhone extends Telephone implements IPlayGame {
    @Override
    public void call() {
        System.out.println("通过语音打电话");
    }

    @Override
    public void message() {
        System.out.println("通过语音发短信");
    }

    @Override
    public void playGame() {
        System.out.println("玩游戏");
    }
}

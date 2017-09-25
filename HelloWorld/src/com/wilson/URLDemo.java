package com.wilson;

import java.io.IOException;
import java.net.URL;

public class URLDemo {
    public static void test() {
        try {
            URL url = new URL("http://www.runoob.com/index.html?language=cn#j2se");
            println("URL 为：" + url.toString());
            println("协议为：" + url.getProtocol());
            println("验证信息：" + url.getAuthority());
            println("文件名及请求参数：" + url.getFile());
            println("主机名：" + url.getHost());
            println("路径：" + url.getPath());
            println("端口：" + url.getPort());
            println("默认端口：" + url.getDefaultPort());
            println("请求参数：" + url.getQuery());
            println("定位位置：" + url.getRef());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static <T> void println(T t) {
        System.out.println(t);
    }
}

package com.wilson;
import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("I love Java");

//        int a=12;
//        int b=24;
//        int sum = a + b;
//
//        System.out.println("两数之和为："+sum);

        /*
        *   1、 与：要求所有人都投票同意，才能通过某议题
            2、 或：只要求一个人投票同意就可以通过某议题
            3、 非：某人原本投票同意，通过非运算符，可以使其投票无效
            4、 异或：有且只能有一个人投票同意，才可以通过某议题
        * */

//        boolean a = true; // a同意
//        boolean b = false; // b反对
//        boolean c = false; // c反对
//        boolean d = true; // d同意
//
//        System.out.println((c ^ d) + "通过");

        /*
        * 使用 Scanner 工具类可以获取用户输入的成绩信息
        * Scanner 位于 java.util 包中。
        *
        * */

//        Scanner input = new Scanner(System.in);
//        System.out.println("请输入：");
//        final int inputValue = input.nextInt();
//        System.out.println("输入的值是：" + inputValue);


        /*
        * 计算班级平均分
        * */
//        int classNum = 3;
//        int stuNum = 4;
//        Scanner input = new Scanner(System.in);
//
//        for (int i = 1; i <= classNum; i++) {
//            double sum = 0;
//            double avg = 0;
//
//            System.out.println("请输入第" + i +"个班级的成绩");
//            for (int j = 1; j <= stuNum; j++) {
//                System.out.println("请输入第" + j +"个学员的成绩");
//                int score = input.nextInt();
//                sum += score;
//            }
//            avg = sum / stuNum;
//            System.out.println("第" + i + "个班级学生的平均分为:" + avg);
//        }


        //定义数组
        //int[] scores = {78, 93, 32, 123, 322};
        //或者 和上面是等价的
        int scores[] = {78, 93, 32, 123, 322};
        System.out.println("数组中的第二个成绩为：" + scores[1]); //93
        scores[1] = 100;
        System.out.println("数组中的第二个成绩为：" + scores[1]); //100


        //数组的声明
        //分配空间
        //简单地说，就是指定数组中最多可存储多少个元素
        //语法：  数组名 = new  数据类型 [ 数组长度 ];
        //数组长度就是数组中能存放元素的个数，如：
        String spy[]= new String[6];
        spy[0] = "hahaha";
        spy[1] = "2";
        System.out.println("spy：" + spy); //100

        //创建一个长度为4的整型数组 下面2中声明方式是等价的
        int[] scores2 = {1,2,3,4};
        int[] scores3 = new int[]{1,2,3,4};

        //定义二维数组
        String[][] names={{"tom","jack","mike"},{"zhangsan","lisi","wangwu"}};


    }

    /*
    * 方法重载
    * 会根据参数类型，参数个数来自动选取执行哪个函数
    * */
    public void print() {
        System.out.println("无参的print方法");
    }

    public void print(String name) {
        System.out.println("带有一个字符串参数的print方法，参数值为：" + name);
    }

    public void print(int age) {
        System.out.println("带有一个整型参数的print方法，参数值为：" + age);
    }
}

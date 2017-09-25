import com.interfaceDemo.IPlayGame;
import com.phone.CellPhone;
import com.phone.Psp;
import com.phone.SmartPhone;
import com.wilson.*;

//包名 需全部为小写。 可以通过包名来区分
//import com.spark.Telephone;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello World, are you ok？");
//
//        Telephone phone = new Telephone();
//        phone.sendMessage();
//        phone.screen = 5.0f;
//        phone.cpu = 1.5f;
//        phone.memory = 2.0f;
////
////
////        Telephone phone2 = new Telephone(1.2f, 3.6f, 7.8f);
////        phone2.sendMessage();
//
//        IPhone iPhone = new IPhone();
//        iPhone.sendMessage();
//
//        //类型装换
//        if (iPhone instanceof Telephone) {
//            //强制转换
//            Telephone tel = (Telephone)iPhone;
//        }

        //
//        testAbstractClass();
//        testInterface();
//        testChar();
//        testStringBuilder();
//        testDate();
//        testGenerics();
//        testSerializable();
//        testUrl();
        testThread();
    }

    public static void testAbstractClass() {
        //
        com.phone.Telephone tel1 = new CellPhone();
        tel1.call();
        tel1.message();

        com.phone.Telephone tel2 = new SmartPhone();
        tel2.call();
        tel2.message();
    }

    public static void testInterface() {
        IPlayGame player = new SmartPhone();
        player.playGame();

        IPlayGame player2 = new Psp();
        player2.playGame();


        IPlayGame player3 = new IPlayGame() {
            @Override
            public void playGame() {
                System.out.println("通过匿名内部类的方式实现接口");
            }
        }; //这里有分号

        player3.playGame();


        ////这样也行
        new IPlayGame() {
            @Override
            public void playGame() {
                System.out.println("通过匿名内部类的方式实现接口-2");
            }
        }.playGame();
    }

    public static void testChar() {
        // 定义一个字符串
        String s = "aljlkdsflkjsadjfklhasdkjlflkajdflwoiudsafhaasdasd";

        // 出现次数
        int num = 0;

        // 循环遍历每个字符，判断是否是字符 a ，如果是，累加次数
        for (int i = 0; i < s.length(); i ++)
        {
            // 获取每个字符，判断是否是字符a
            if (s.charAt(i) == 'a') {
                // 累加统计次数
                num++;
            }
        }
        System.out.println("字符a出现的次数：" + num);

    }

    public static void testStringBuilder() {
        //String类是不可变，但StringBuilder类是可变的。
        String str = "hahaha";
        String str1 = new String("are you ok");
        //这里str所指向了新的内存地址。
        str += str1;


        //如果需要创建一个内容可变的字符串对象，应优先考虑使用 StringBuilder 类。
        StringBuilder hobby = new StringBuilder("are");
        System.out.println(hobby);
        hobby.append(" you");
        System.out.println(hobby);
        hobby.insert(hobby.length(), " ok?");
        System.out.println(hobby.toString());


        testStringBuilderInsert();

    }

    public static void testStringBuilderInsert() {
        // 创建一个空的StringBuilder对象
        StringBuilder str = new StringBuilder();

        // 追加字符串
        str.append("jaewkjldfxmopzdm");

        for (int i = str.length()-3; i >= 0 ; i -= 3) {
            str.insert(i, ',');
        }
        // 将StringBuilder对象转换为String对象并输出
        System.out.print(str.reverse().toString());
    }

    public static void testWrappingNumberType() {
        int score = 86;

        /**
         * 装箱：把基本类型转换成包装类，使其具有对象的性质，又可分为手动装箱和自动装箱
         */
        //手动装箱
        Integer score1 = new Integer(score);
        //自动装箱
        Integer score2 = score;

        /**
         * 拆箱：和装箱相反，把包装类对象转换成基本类型的值，又可分为手动拆箱和自动拆箱
         */
        //手动拆箱
        int score3 = score1.intValue();

        //自动拆箱
        int score4 = score1;

        //类型转换

        //to string
        String stringScore = score1.toString();

        //string to int
        int score5 = Integer.parseInt(stringScore);
        int score6 = Integer.valueOf(stringScore);

    }

    public static void testDate() {
        Date d = new Date(); //
        System.out.println(d);

        //格式转换
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String today = sdf.format(d);

        System.out.println(today);

        String day = "2017-09-21 10:05:03";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = df.parse(day);
            System.out.println(date);
        } catch (ParseException e) {

        }
    }

    public static void testCalendar() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
    }

    public static void testMath() {
        double a = 12.81;

        //强制转换去掉小数点
        int b = (int)a;
        //四舍五入
        long c = Math.round(a);
        //向上取整
        double d = Math.floor(a);
        //向下取整
        double e = Math.ceil(a);

        //Collection
        //ArrayList
        //Map

    }

    public static void testGenerics() {
        Generic generic = new Generic();
        generic.test();
    }

    public static void testSerializable() {
        Serialization.testSerializable();
    }

    public static void testUrl() {
        URLDemo.test();
    }

    public static void testThread() {
        ThreadDemo.test();
    }
}

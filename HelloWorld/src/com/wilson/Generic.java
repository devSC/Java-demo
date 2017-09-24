package com.wilson;

/*
 * 泛型
 *
 * 泛型提供了编译时类型安全检测机制，该机制允许程序员在编译时检测到非法的类型。
 *
 * 泛型的本质是参数化类型，也就是说所操作的数据类型被指定为一个参数。
 *
 * 下面是定义泛型方法的规则：
   所有泛型方法声明都有一个类型参数声明部分（由尖括号分隔），该类型参数声明部分在方法返回类型之前（在下面例子中的<E>）。

   每一个类型参数声明部分包含一个或多个类型参数，参数间用逗号隔开。一个泛型参数，也被称为一个类型变量，是用于指定一个泛型类型名称的标识符。

   类型参数能被用来声明返回值类型，并且能作为泛型方法得到的实际参数类型的占位符。

   泛型方法体的声明和其他方法一样。注意类型参数只能代表引用型类型，不能是原始类型（像int,double,char的等）。
 */
public class Generic {

    //泛型方法 printArray
    public static <E> void printArray(E[] inputArray) {
        //输出数组元素
        for (E element: inputArray) {
            System.out.println(element + " ");
        }
        System.out.println();
    }


    /**
     * 有界的类型参数:
     *
     * 限制那些被允许传递到一个类型参数的类型种类范围。
     * 例如，一个操作数字的方法可能只希望接受Number或者Number子类的实例。这就是有界类型参数的目的。
     *
     * 要声明一个有界的类型参数，首先列出类型参数的名称，后跟extends关键字，最后紧跟它的上界。
     *
     *  这里可以限制 泛型参数的类型 "extends"在一般意义上的意思"extends"（类）或者"implements"（接口）
     */
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x; //
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }


    public static <T> void println(T t) {
        System.out.println(t);
    }

    public void test() {
        //
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        System.out.println("整形数组元素为: ");
        printArray(intArray);

        System.out.println("双精度型数组元素为: ");
        printArray(doubleArray);

        System.out.println("字符数组元素为: ");
        printArray(charArray);

        println("3, 4, 5 中最大的数为" + maximum(3, 4,5));


        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<String>();

        integerBox.add(10);
        stringBox.add(new String("Hello world"));

        System.out.printf("整型值为 :%d\n\n", integerBox.get());
        System.out.printf("字符串为 :%s\n", stringBox.get());

        //使用类型通配符
        getData(integerBox);
        getData(stringBox);

        getNumberData(integerBox);

        getSuperNumberData(integerBox);
    }

    /**
     * 泛型类
     * 泛型类的声明和非泛型类的声明类似，除了在类名后面添加了类型参数声明部分。
     *
     * 和泛型方法一样，泛型类的类型参数声明部分也包含一个或多个类型参数，参数间用逗号隔开。
     * 一个泛型参数，也被称为一个类型变量，是用于指定一个泛型类型名称的标识符。
     * 因为他们接受一个或多个参数，这些类被称为参数化的类或参数化的类型。
     */

    public class Box<T> { //类似于C++ 中的模板
        private T t;

        public void add(T t) {
            this.t = t;
        }

        public T get() {
            return t;
        }
    }

    /**
     * 类型通配符
     *  类型通配符一般是使用?代替具体的类型参数。
     *  例如 List<?> 在逻辑上是List<String>,List<Integer> 等所有List<具体类型实参>的父类。
     */

    public static void getData(Box<?> box) {
        println("data: " + box.get());
    }

    //可以通过有界参数来限制类型
    public static void getNumberData(Box<? extends Number> box) {
        println("number data: " + box.get());
    }

    //类型通配符下限通过形如 List<? super Integer>来定义，表示类型只能接受Integer及其三层父类类型，如Object类型的实例。
    public static void getSuperNumberData(Box<? super Integer> box) {
        println("super number data: " + box.get());
    }

    /**
     * <? extends T>和<? super T>的区别
     *
     * <? extends T>表示该通配符所代表的类型是T类型的子类。
     * <? super T>表示该通配符所代表的类型是T类型的父类。
     */
}


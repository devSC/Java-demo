package com.wilson;
import java.io.*;

/**
 * Java 序列化
 *
 * 一个对象可以被表示为一个字节序列，该字节序列包括该对象的数据、有关对象的类型的信息和存储在对象中数据的类型。
 *
 * 将序列化对象写入文件之后，可以从文件中读取出来，并且对它进行反序列化，
 * 也就是说，对象的类型信息、对象的数据，还有对象中的数据类型可以用来在内存中新建对象。
 *
 *
 * 整个过程都是 Java 虚拟机（JVM）独立的，
 * 也就是说，在一个平台上序列化的对象可以在另一个完全不同的平台上反序列化该对象。
 *
 */

/***
 * 一个类的对象要想序列化成功，必须满足两个条件：
 * 该类必须实现 java.io.Serializable 对象。
 * 该类的所有属性必须是可序列化的。如果有一个属性不是可序列化的，则该属性必须注明是(transient)短暂的。
 *
 */
class Employee implements Serializable {
    public String name;
    public String address;

    //transient: 短暂的
    public transient int SSN;

    public int number;
    public void mailCheck() {
        System.out.println("Mailing a check to " + name + " " + address);
    }
}


public class Serialization {

    public static void testSerializable() {
        Employee e = new Employee();
        e.name = "Rayan Ali";
        e.address = "Phokka kuan spaooe Sparl";
        e.SSN = 9928881;
        e.number = 1001;

        try {

            //序列化对象
            FileOutputStream fileOut = new FileOutputStream("/tmp/employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/employee.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }


        //反序列化
        Employee re = null;
        try {
            FileInputStream fileIn = new FileInputStream("/tmp/employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            re = (Employee) in.readObject();
            in.close();
            fileIn.close();

        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }

        System.out.println("Deserialized Employee...");
        System.out.println("Name: " + re.name);
        System.out.println("Address: " + re.address);
        System.out.println("SSN: " + re.SSN);
        System.out.println("Number: " + re.number);
    }

}


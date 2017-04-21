package org.javacore.io.serializable;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

/**
 * Created by Guosi Chen on 2017/4/21.
 * JAVA 序列化与反序列化
 */
public class SerializableT {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        for (int i = 0; i < 10; i++) {
            AObject aObject = new AObject();
            long beginTime = System.currentTimeMillis();

            ByteOutputStream byteOutputStream = new ByteOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteOutputStream);
            objectOutputStream.writeObject(aObject);
            objectOutputStream.close();
            byteOutputStream.close();
            byte[] bytes = byteOutputStream.getBytes();
            System.out.println("Java序列化耗时：" + (System.currentTimeMillis() - beginTime) + "ms");
            System.out.println("Java序列化后的字节大小为：" + bytes.length);

            beginTime = System.currentTimeMillis();
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteInputStream);
            objectInputStream.readObject();
            objectInputStream.close();
            byteInputStream.close();
            System.out.println("Java反序列化耗时：" + (System.currentTimeMillis() - beginTime) + "ms");
        }
    }

}

class AObject implements Serializable {
    private String a = "bysocket";

    private String b = "likes";

    private String c = "java";

    private String d = "world";

    private int i = 100;

    private int j = 10;

    private long m = 100L;

    private boolean isA = true;

    private boolean isB = false;

    private boolean isC = false;

    private BObject aObject = new BObject();

    private BObject bObject = new BObject();

    private BObject cObject = new BObject();

    private BObject dObject = new BObject();

}

class BObject implements Serializable {

}

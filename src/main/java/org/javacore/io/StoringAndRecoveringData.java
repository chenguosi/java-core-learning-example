package org.javacore.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Guosi Chen on 2017/4/26.
 * DataOutputStream和DataInputStream的使用案例
 */
public class StoringAndRecoveringData {

    public static void main(String[] args) throws IOException {
        // 写入数据
        DataOutputStream dataOutputStream =
                new DataOutputStream(new BufferedOutputStream(new FileOutputStream("data.txt")));
        dataOutputStream.writeDouble(3.1415926);
        dataOutputStream.writeUTF("你好");
        dataOutputStream.writeInt(1);
        dataOutputStream.close();

        // 读取数据
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream("data.txt")));
        dataInputStream.readDouble();
        System.out.println(dataInputStream.readUTF());
        System.out.println(dataInputStream.readInt());
        dataInputStream.close();
    }
}

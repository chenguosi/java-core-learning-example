package org.javacore.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;

/**
 * Created by Guosi Chen on 2017/4/26.
 * 格式化内存输入
 */
public class FormatMemoryInput {

    public static void main(String[] args) {
        String filePath = "src" + File.separator + "main" + File.separator +
                "java" + File.separator +
                "org" + File.separator + "javacore" + File.separator +
                "io" + File.separator + "FormatMemoryInput.java";
        try {
            DataInputStream dataInputStream = new DataInputStream(
                    // 缓冲区字节输入
                    new ByteArrayInputStream(BufferedInputFileT.read(filePath).getBytes())
            );
            while (true){
                System.out.println((char)dataInputStream.readByte());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

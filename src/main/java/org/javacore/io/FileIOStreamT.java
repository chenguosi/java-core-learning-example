package org.javacore.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Guosi Chen on 2017/4/25.
 * FileInputStream&FileOutputStream使用案例
 */
public class FileIOStreamT {

    private static final String thisFilePath =
            "src" + File.separator + "main" + File.separator + "java" + File.separator + "org" + File.separator
                    + "javacore" + File.separator + "io" + File.separator + "FileIOStreamT.java";

    public static void main(String[] args) throws IOException {
        // 创建文件输入流
        FileInputStream fileInputStream = new FileInputStream(thisFilePath);
        // 创建文件输出流
        FileOutputStream fileOutputStream = new FileOutputStream("data.txt");

        // 创建流的最大字节数组
        byte[] bytes = new byte[fileInputStream.available()];
        // 将文件输入流读取,保存至bytes数组
        fileInputStream.read(bytes);
        // 将bytes数组,写出到data.txt文件
        fileOutputStream.write(bytes);

        fileInputStream.close();
        fileOutputStream.close();
    }
}

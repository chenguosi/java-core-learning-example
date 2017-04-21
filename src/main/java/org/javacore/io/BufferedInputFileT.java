package org.javacore.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Guosi Chen on 2017/4/21.
 * 缓冲输入文件
 */
public class BufferedInputFileT {

    /**
     * 通过文件名，读取文件并缓冲
     * @param fileName
     * @return
     * @throws IOException
     */
    public static String read(String fileName) throws IOException {
        // 通过行读取输入
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String s;
        StringBuffer sb = new StringBuffer(); // 此处使用了线程安全的StringBuffer,但效率没有StringBuilder高
        while ((s = bufferedReader.readLine()) != null) {
            sb.append(s + "\n");
        }
        bufferedReader.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        // 缓冲输入文件，并打印
        // System.out.println(System.getProperty("user.dir"));
        String filePath =
                System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator
                        + "java" + File.separator + "org" + File.separator + "javacore" + File.separator + "io";
        System.out.println(read(filePath + File.separator + "BufferedInputFileT.java"));
    }
}

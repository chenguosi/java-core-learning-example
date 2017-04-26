package org.javacore.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by Guosi Chen on 2017/4/26.
 * System.out, System.err中IO的使用
 * 替换系统流，输出至文本
 */
public class SystemStreamT {

    public static void main(String[] args) throws IOException {
        // 创建文件输出流
        OutputStream outputStream = new FileOutputStream("D:\\data\\console.txt");
        // 创建新的文件输出打印流
        PrintStream printStream = new PrintStream(outputStream);
        // 设置标准输出流
        System.setOut(printStream);
        // 设置标准错误输出流
        System.setErr(printStream);

        System.out.println("Hello,System.out");
        System.out.println("Hello,System.err");

        // 关闭流
        printStream.close();
        outputStream.close();
    }
}

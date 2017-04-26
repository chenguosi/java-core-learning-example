package org.javacore.io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Guosi Chen on 2017/4/26.
 * RandomAccessFile的使用
 */
public class RandomAccessFileT {

    public static void main(String[] args) throws IOException {
        // 获取文件,读写方式
        RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\u03\\file.txt", "rw");
        // 设置文件指针位置
        randomAccessFile.seek(6);
        // 文件中的当前偏移量
        System.out.println(randomAccessFile.getFilePointer());
        // 读取文本的一个字节
        System.out.println((char) randomAccessFile.read()); // int字节，转char显示
        // 写入字节数组
        randomAccessFile.write("Hello World".getBytes());
        // 初始化文件指针位置
        randomAccessFile.seek(0);
        // 读取文本的一行
        System.out.println(randomAccessFile.readLine());
        randomAccessFile.close();
    }
}

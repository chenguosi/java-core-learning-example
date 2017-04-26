package org.javacore.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by Guosi Chen on 2017/4/26.
 */
public class TextFile extends ArrayList<String> {

    // 读取文件内容，返回内容字符串
    public static String read(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            // 创建缓存字符输入流
            BufferedReader bufferedReader = new BufferedReader(new FileReader( // 创建读取字符文件类
                    new File(fileName).getAbsolutePath()));// 文件绝对路径地址
            String s;
            try {
                // 读取一个文本行
                while ((s = bufferedReader.readLine()) != null) {
                    stringBuilder.append(s + "\n");
                }
            } finally {
                bufferedReader.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    // 将字符串写入一个文本
    public static void write(String fileName, String text) {
        try {
            // 创建打印输出流
            PrintWriter printWriter = new PrintWriter(new File(fileName).getAbsolutePath());
            // 写入字符流
            printWriter.write(text);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 通过正则匹配,读取文件
    public TextFile(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
        // 移除一个空格位置
        if ("".equals(get(0))) {
            remove(0);
        }
    }

    public TextFile(String fileName) {
        this(fileName, "\n");
    }

    // 写入一个文本文件
    public void write(String fileName) {
        try {
            // 创建打印输出流
            PrintWriter printWriter = new PrintWriter(new File(fileName).getAbsolutePath());
            for (String item : this) {
                printWriter.write(item);
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 读取文件
        String file = read("src/org/javacore/io/TextFile.java");
        // 写入到test.txt
        write("test.txt", file);

        TextFile text = new TextFile("test.txt");
        text.write("test2.txt");

        TreeSet<String> words = new TreeSet<>(new TextFile("src/org/javacore/io/TextFile.java", "\\W+"));
        System.out.println(words.headSet("a"));

    }

}

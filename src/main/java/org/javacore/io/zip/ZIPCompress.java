package org.javacore.io.zip;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by Guosi Chen on 2017/4/21.
 * 利用Zip进行多文件保存
 */
public class ZIPCompress {

    /*
     * private static String filePath =
     * System.getProperty("user.dir") + File.separator + "src" + File.separator
     * + "main" + File.separator + "java"
     * + File.separator + "org" + File.separator + "javacore" + File.separator +
     * "io" + File.separator;
     * 
     * private static String[] fileNames =
     * new String[] { filePath + "BufferedInputFileT.java", filePath +
     * "ChangeSystemOut.java" };
     */

    private static String[] fileNames = new String[] { "src/main/java/org/javacore/io/BufferedInputFileT.java",
            "src/main/java/org/javacore/io/ChangeSystemOut.java" };

    public static void main(String[] args) throws IOException {
        zipFiles(fileNames);
    }

    public static void zipFiles(String[] fileNames) throws IOException {
        // 获取zip文件输出流
        FileOutputStream fileOutputStream = new FileOutputStream("test.zip");
        // 从文件输出流中获取数据校验和输出流,并设置Adler32
        CheckedOutputStream checkedOutputStream = new CheckedOutputStream(fileOutputStream, new Adler32());
        // 从数据校验和输出流中获取zip输出流
        ZipOutputStream zipOutputStream = new ZipOutputStream(checkedOutputStream);
        // 从zip输出流中获取缓冲输出流
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(zipOutputStream);
        // 设置Zip文件注释
        zipOutputStream.setComment("测试 java zip stream");
        for (String file : fileNames) {
            System.out.println("写入文件:   " + file);
            // 获取文件输入字符流
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            // 想Zip处理写入新的文件条目,并流定位到数据开始处
            zipOutputStream.putNextEntry(new ZipEntry(file));
            int a;
            while ((a = bufferedReader.read()) > 0) {
                bufferedOutputStream.write(a);
            }
            bufferedReader.close();
            // 刷新zip输出流,将缓冲的流写入该数据
            bufferedOutputStream.flush();
        }
        // 文件全部写入Zip输出流后,关闭
        bufferedOutputStream.close();
        zipOutputStream.close();
        checkedOutputStream.close();
        fileOutputStream.close();

        // 输出数据校验和
        System.out.println("数据校验和:  " + checkedOutputStream.getChecksum().getValue());
        System.out.println("读取zip文件");
        // 读取test.zip文件输入流
        FileInputStream fileInputStream = new FileInputStream("test.zip");
        // 从文件输入流中获取数据校验和流
        CheckedInputStream checkedInputStream = new CheckedInputStream(fileInputStream, new Adler32());
        // 从数据校验和流中获取Zip解压流
        ZipInputStream zipInputStream = new ZipInputStream(checkedInputStream);
        // 从zip解压流中获取缓冲输入流
        BufferedInputStream bufferedInputStream = new BufferedInputStream(zipInputStream);
        // BufferedReader bufferedReader = new BufferedReader(new
        // InputStreamReader(zipInputStream,"UTF-8"));
        // 创建文件条目
        ZipEntry zipEntry;
        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
            System.out.println("读取文件:   " + zipEntry);
            int x;
            while ((x = bufferedInputStream.read()) > 0) {
                System.out.write(x);
            }
        }
        if (fileNames.length == 1) {
            System.out.println("数据校验和:  " + checkedInputStream.getChecksum().getValue());
        }
        bufferedInputStream.close();
        zipInputStream.close();
        checkedInputStream.close();
        fileInputStream.close();

        // 获取zip文件
        ZipFile zipFile = new ZipFile("test.zip");
        // 获取文件条目枚举
        Enumeration<? extends ZipEntry> enumeration = zipFile.entries();
        while (enumeration.hasMoreElements()) {
            // 从zip文件的枚举中获取文件条目
            ZipEntry entry = enumeration.nextElement();
            System.out.println("文件: " + entry);
        }
        zipFile.close();
    }
}

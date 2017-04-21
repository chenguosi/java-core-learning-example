package org.javacore.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Guosi Chen on 2017/4/21.
 * 文件复制
 */
public class CopyFileT {
    public static void main(String[] args) throws IOException {
        String filePath =
                System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator
                        + "java" + File.separator + "org" + File.separator + "javacore" + File.separator + "io";
        String resource = filePath + File.separator + "CopyFileT.java";
        String destination = "D:" + File.separator + "u03" + File.separator + "CopyFileA.java";
        copyFile(resource, destination);
    }

    public static void copyFile(String resource, String destination) throws IOException {
        File srcFile = new File(resource);
        File destFile = new File(destination);
        // 文件不存在
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("文件: " + srcFile + "不存在");
        }
        // 文件不是文件类型
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是文件");
        }
        FileInputStream fileInputStream = new FileInputStream(srcFile);
        FileOutputStream fileOutputStream = new FileOutputStream(destFile);
        byte[] bytes = new byte[2 * 1024];
        int b;
        while ((b = fileInputStream.read(bytes, 0, bytes.length)) != -1) {
            fileOutputStream.write(bytes, 0, b);
            fileOutputStream.flush();
        }
        fileOutputStream.close();
        fileInputStream.close();
    }
}

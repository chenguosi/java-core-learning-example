package org.javacore.io;

import java.io.File;
import java.io.IOException;

/**
 * Created by Guosi Chen on 2017/4/26.
 * File类的使用
 */
public class FileT {

    public static void main(String[] args) {
        // 创建一个目录
        File dir = new File("D:" + File.separator + "u03" + File.separator + "dir" + File.separator + "test");
        dir.mkdirs();
        // 创建一个文件
        File file = new File(dir, "test.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 是否是一个目录
        System.out.println(dir.isDirectory());
        // 是否是一个文件
        System.out.println(file.isFile());

        // 删除文件
        if (file.delete()) {
            System.out.println(file.getName() + " 被删除了！");
        } else {
            System.out.println("文件删除失败!");
        }
    }
}

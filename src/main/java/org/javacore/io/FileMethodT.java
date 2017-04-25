package org.javacore.io;

import java.io.File;

/**
 * Created by Guosi Chen on 2017/4/25.
 * File方法详细使用
 */
public class FileMethodT {

    public static void fileData(File file) {
        System.out.println(
                "绝对路径:   " + file.getAbsolutePath() +
                        "\n 可读: " + file.canRead() +
                        "\n 可写: " + file.canWrite() +
                        "\n 文件名:    " + file.getName() +
                        "\n 上级目录:   " + file.getParent() +
                        "\n 相对地址:   " + file.getPath() +
                        "\n 长度: " + file.length() +
                        "\n 最近修改时间: " + file.lastModified()
        );

        if (file.isFile()) {
            System.out.println(file + " 是一个文件");
        }else if (file.isDirectory()){
            System.out.println(file + " 是一个目录");
        }
    }

    public static void main(String[] args) {
        //获取src目录
        File file = new File("src");
        //file详细操作
        fileData(file);
    }
}

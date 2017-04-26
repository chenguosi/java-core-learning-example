package org.javacore.io;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by Guosi Chen on 2017/4/26.
 * 类名过滤器的使用
 */
public class FilenameFilterT {

    public static void main(String[] args) {
        // IO包路径
        String path = "src" + File.separator + "org" + File.separator + "javacore" + File.separator + "io";
        File file = new File(path);
        // 创建过滤器文件
        MyFilter myFilter = new MyFilter(".java");
        // 过滤
        String[] files = file.list(myFilter);
        if (files == null) {
            System.out.println("没有找到文件");
        } else {
            // 打印
            for (String name : files) {
                System.err.println(name);
            }
        }
    }

    /**
     * 静态内部类实现过滤器文件接口
     */
    public static class MyFilter implements FilenameFilter {

        private String type;

        public MyFilter(String type) {
            this.type = type;
        }

        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(type); // 以type结尾
        }
    }
}

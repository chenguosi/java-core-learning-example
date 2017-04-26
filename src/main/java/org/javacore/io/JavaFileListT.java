package org.javacore.io;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by Guosi Chen on 2017/4/26.
 * FilenameFilter文件过滤器的使用
 */
public class JavaFileListT {

    // 文件过滤接口
    // 作为匿名内部类，变量type必须声明为final类型  JAVA8的匿名内部类变量可以省略final修饰，但实际还是按照final来使用
    public static FilenameFilter javaFileFilter(String type) {
        // 过滤接口-匿名内部类
        return new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(name).getName().indexOf(type) != -1;
            }
        };
    }

    public static void main(String[] args) {
        // 创建一个目录
        File file = new File("src\\main\\java\\org\\javacore\\io"); // 当前目录
        // 获取文件名数组
        String fileNames[] = file.list(javaFileFilter(".java"));
        // 打印
        for (String item : fileNames) {
            System.out.println(item);
        }
    }

}

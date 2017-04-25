package org.javacore.io;

import java.io.File;
import java.util.Arrays;

/**
 * Created by Guosi Chen on 2017/4/25.
 * 列出目录并排序
 */
public class DirListT {
    public static void main(String[] args) {
        File path = new File("./src/main/java/org/javacore/io"); // 表示当前目录
        // 文件路径名数组
        String[] list = path.list();
        // 对String 文件名进行排序
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);

        // 打印
        for (String s : list) {
            System.out.println(s);
        }
    }
}

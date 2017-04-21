package org.javacore.io.zip;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by Guosi Chen on 2017/4/21.
 * GZIP简单使用
 */
public class GZIPCompress {
    public static void main(String[] args) throws IOException {
        // 用Reader读取文件
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(new FileInputStream("data.gz"), "UTF-8"));
        // 使用缓冲输出流，输出压缩文件
        BufferedOutputStream bufferedOutputStream =
                new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("data.gz")));
        System.out.println("Writing File 压缩");
        int c;
        while ((c = bufferedReader.read()) > 0) {
            bufferedOutputStream.write(c);
        }
        bufferedOutputStream.flush();
        bufferedReader.close();
        bufferedOutputStream.close();

        System.out.println("Reading File 解压");
        // 用输入解压流读取文件
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("data.gz")), "UTF-8"));
        String s;
        while ((s = reader.readLine()) != null){
            System.out.println(s);
        }
        reader.close();
    }
}

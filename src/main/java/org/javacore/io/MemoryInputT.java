package org.javacore.io;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by Guosi Chen on 2017/4/26.
 * 内存中输入
 */
public class MemoryInputT {

    public static void main(String[] args) throws IOException {
        StringReader stringReader = new StringReader(BufferedInputFileT.read(
                "src" + File.separator + "main" + File.separator + "java" + File.separator + "org" + File.separator
                        + "javacore" + File.separator + "io" + File.separator + "BufferedInputFileT.java"));
        int a;
        while ((a = stringReader.read()) != -1) { // int形式
            System.out.println((char) a); // int字节,转char显示
        }
    }
}

package org.javacore.io;

import java.io.PrintWriter;

/**
 * Created by Guosi Chen on 2017/4/21.
 * 改变System.out输出案例
 */
public class ChangeSystemOut {
    public static void main(String[] args) {
        PrintWriter printWriter = new PrintWriter(System.out, true);
        printWriter.print("Hello PrintWriter");
        printWriter.close();
    }
}

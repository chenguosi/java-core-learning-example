package org.javacore.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by Guosi Chen on 2017/4/26.
 * 管道输入输出流的使用
 * 同一个JVM中，两个线程直接的字节流通信
 */
public class PipeStreamT {

    public static void main(String[] args) throws IOException {
        // 创建管道输出流
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        // 创建管道输入流，并连接到管道输出流
        @SuppressWarnings("resource")
        PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);
        // PipedInputStream pipedInputStream = new PipedInputStream();
        // pipedInputStream.connect(pipedOutputStream); // 等价于

        Thread outThread = new Thread(new Runnable() {
            @Override
            public void run() {
                // 将指定的字节数组写入管道输出流
                try {
                    pipedOutputStream.write("Hello,PipedStream!".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread inputThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 读取管道输入流中的下一个数据字节
                    int data = pipedInputStream.read();
                    while (data != -1) {
                        System.out.println((char)data);
                        // 再次去读下一个字节
                        data = pipedInputStream.read();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        inputThread.start();
        outThread.start();

    }
}

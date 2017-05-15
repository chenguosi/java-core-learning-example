package org.javacore.lambda;

/**
 * Created by Guosi Chen on 2017/4/27.
 * Lambda - 启动线程
 */
public class LambdaRunnable {

    private static volatile int b = 10;

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                b++;
                System.out.println("Old " + b);
            }
        });

        // Lambda - 启动线程
        Thread lambdaThread = new Thread(() -> {
            b++;
            System.out.println("New " + b);
        });

        thread.start();
        lambdaThread.start();
        System.out.println("Done!");

    }
}

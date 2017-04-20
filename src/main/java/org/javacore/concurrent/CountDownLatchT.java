package org.javacore.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Guosi Chen on 2017/4/20.
 * 同步辅助类:完成一组线程执行前,使得一个或多个线程一直等待
 */
public class CountDownLatchT {

    // 线程中止的计数器
    private static final int COUNT = 10;

    private static final CountDownLatch count = new CountDownLatch(COUNT);

    // 线程池
    private static final ExecutorService service = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < COUNT; i++) {
            service.execute(
                    /*new Runnable() {
                        @Override
                        public void run() {
                            int time = new Random().nextInt(5);
                            try {
                                TimeUnit.SECONDS.sleep(time);
                                System.out.printf("Thread %s ## 耗时:%d\n", Thread.currentThread().getId(), time);
                                // 线程结束后,计数器减一
                                count.countDown();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }*/
                    () -> {
                int time = new Random().nextInt(5);
                try {
                    TimeUnit.SECONDS.sleep(time);
                    System.out.printf("Thread %s ## 耗时:%d\n", Thread.currentThread().getId(), time);
                    // 线程结束后,计数器减一
                    count.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            );
        }
        // 主线程一直被阻塞,直到count为0,实现线程同步
        count.await();
        service.shutdown();
        System.out.println("同步线程执行组结束!");
    }
}

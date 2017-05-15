package org.javacore.scheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Guosi Chen on 2017/5/15.
 * ScheduledExecutorService的使用
 */
public class SchedulerExecutorTest implements Runnable {

    private final String jobName;

    public SchedulerExecutorTest(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public void run() {
        System.out.println("running =>" + jobName);
    }

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        // 一秒
        executorService.scheduleAtFixedRate(new SchedulerExecutorTest("job1"), 1, 1, TimeUnit.SECONDS);
        // 两秒
        executorService.scheduleWithFixedDelay(new SchedulerExecutorTest("job2"), 1, 2, TimeUnit.SECONDS);
    }
}

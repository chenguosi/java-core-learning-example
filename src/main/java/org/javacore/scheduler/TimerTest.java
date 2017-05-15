package org.javacore.scheduler;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Guosi Chen on 2017/5/15.
 * Timer的使用
 */
public class TimerTest extends TimerTask {

    private final String jobName;

    public TimerTest(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public void run() {
        System.out.println("run the task => " + jobName);
    }

    public static void main(String[] args) {
        // 一种工具，线程用其安排以后在后台线程中执行的任务
        Timer timer = new Timer();
        timer.schedule(new TimerTest("job1"), 1000, 1000); // 一秒
        timer.schedule(new TimerTest("job2"), 1000, 2000); // 两秒
    }
}

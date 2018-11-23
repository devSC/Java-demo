package com.wilson;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//MORE: https://guides.codepath.com/android/Repeating-Periodic-Tasks#alarmmanager
public class ScheduleExample {
    final static DateFormat fmt = DateFormat.getTimeInstance(DateFormat.LONG);
    static Integer times = 0;
    static ScheduledFuture<?> periodicfFuture;

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor sch = new ScheduledThreadPoolExecutor(5);
        sch.shutdown();
        Runnable oneShotTask = new Runnable() {
            @Override
            public void run() {
                System.out.println("\t oneShotTask Execution time: " + fmt.format(new Date()));
            }
        };

        Runnable delayTask = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("\t delayTask Execution Time: " + fmt.format(new Date()));
                    Thread.sleep(10 * 1000);
                    System.out.println("\t delayTask End Time: " + fmt.format(new Date()));
                } catch (Exception e) {

                }
            }
        };

        Runnable periodicTask = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("\t  Execute times: " + times.toString() + " periodicTask Execution Time: " + fmt.format(new Date()));
                    times += 1;
                    Thread.sleep(3 * 1000);
                    System.out.println("\t periodicTask End Time: " + fmt.format(new Date()));
                    if (times > 3 && periodicfFuture != null) {
                        periodicfFuture.cancel(false);
                        System.out.println("\t periodicTask cancelled: " + fmt.format(new Date()));
                    }
                } catch (Exception e) {

                }
            }
        };
        System.out.println("Submission Time: " + fmt.format(new Date()));
//        ScheduledFuture<?> oneShotFuture = sch.schedule(oneShotTask, 5, TimeUnit.SECONDS);
//        ScheduledFuture<?> delayFuture = sch.scheduleWithFixedDelay(delayTask, 5, 5, TimeUnit.SECONDS);
        periodicfFuture = sch.scheduleAtFixedRate(periodicTask, 5, 5, TimeUnit.SECONDS);
    }
}

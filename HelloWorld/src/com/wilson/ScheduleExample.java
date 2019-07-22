package com.wilson;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class CancelableExecutionRunnable implements Runnable {

    private final AtomicInteger runCount = new AtomicInteger();
    private final Runnable delegate;
    private volatile ScheduledFuture<?> self;
    private final int maxRunCount;

    CancelableExecutionRunnable (Runnable delegate, int maxRunCount) {
        this.delegate = delegate;
        this.maxRunCount = maxRunCount;
    }

    @Override
    public void run() {
        delegate.run();
        if (runCount.incrementAndGet() == maxRunCount) {
            boolean interrupted = false;
            try {
                System.out.println("\t CancelableExecutionRunnable will end: " + DateFormat.getTimeInstance(DateFormat.LONG).format(new Date()));
                interrupted = true;
//                while (self == null) {
//                    try {
//                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        interrupted = true;
//                        e.printStackTrace();;
//                    }
//                }
            } finally {
                if (interrupted) {
                    Thread.currentThread().interrupt();
                    self.cancel(true);
                }
            }
//            self.cancel(false);
        }
    }

    public void runNTimes(ScheduledExecutorService executorService, long period, TimeUnit unit) {
        self = executorService.scheduleAtFixedRate(this, 0, period, unit);
    }
}

//MORE: https://guides.codepath.com/android/Repeating-Periodic-Tasks#alarmmanager
public class ScheduleExample {
    final static DateFormat fmt = DateFormat.getTimeInstance(DateFormat.LONG);
    static Integer times = 0;
    static ScheduledFuture<?> periodicfFuture;

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor sch = new ScheduledThreadPoolExecutor(2);
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
            Integer times = 0;
            @Override
            public void run() {
                try {
                    System.out.println("\t -1  Execute times: " + times.toString() + " periodicTask Execution Time: " + fmt.format(new Date()));
                    times += 1;
                    Thread.sleep(3 * 1000);
                    System.out.println("\t -1 periodicTask End Time: " + fmt.format(new Date()));
                    if (times > 3 && periodicfFuture != null) {
                        periodicfFuture.cancel(false);
                        System.out.println("\t -1 periodicTask cancelled: " + fmt.format(new Date()));
                    }
                } catch (Exception e) {

                }
            }
        };

        Runnable periodicTask2 = new Runnable() {
            Integer times = 0;
            @Override
            public void run() {
                try {
                    System.out.println("\t -2 Execute times: " + times.toString() + " periodicTask Execution Time: " + fmt.format(new Date()));
                    times += 1;
                    Thread.sleep(3 * 1000);
                    System.out.println("\t -2 periodicTask End Time: " + fmt.format(new Date()));
                    if (times > 3 && periodicfFuture != null) {
                        periodicfFuture.cancel(false);
                        System.out.println("\t -2 periodicTask cancelled: " + fmt.format(new Date()));
                    }
                } catch (Exception e) {

                }
            }
        };
        Runnable periodicTask3 = new Runnable() {
            Integer times = 0;
            @Override
            public void run() {
                try {
                    System.out.println("\t -3  Execute times: " + times.toString() + " periodicTask Execution Time: " + fmt.format(new Date()));
                    times += 1;
                    Thread.sleep(3 * 1000);
                    System.out.println("\t -3 periodicTask End Time: " + fmt.format(new Date()));
                    if (times > 3 && periodicfFuture != null) {
                        periodicfFuture.cancel(false);
                        System.out.println("\t -3 periodicTask cancelled: " + fmt.format(new Date()));
                    }
                } catch (Exception e) {

                }
            }
        };
        Runnable periodicTask4 = new Runnable() {
            Integer times = 0;
            @Override
            public void run() {
                try {
                    System.out.println("\t -4  Execute times: " + times.toString() + " periodicTask Execution Time: " + fmt.format(new Date()));
                    times += 1;
                    Thread.sleep(3 * 1000);
                    System.out.println("\t -4 periodicTask End Time: " + fmt.format(new Date()));
                    if (times > 3 && periodicfFuture != null) {
                        periodicfFuture.cancel(false);
                        System.out.println("\t -4 periodicTask cancelled: " + fmt.format(new Date()));
                    }
                } catch (Exception e) {

                }
            }
        };
        System.out.println("Submission Time: " + fmt.format(new Date()));
//        ScheduledFuture<?> oneShotFuture = sch.schedule(oneShotTask, 5, TimeUnit.SECONDS);
//        ScheduledFuture<?> delayFuture = sch.scheduleWithFixedDelay(delayTask, 5, 5, TimeUnit.SECONDS);
//        periodicfFuture = sch.scheduleAtFixedRate(periodicTask, 5, 5, TimeUnit.SECONDS);
        CancelableExecutionRunnable runnable = new CancelableExecutionRunnable(periodicTask, 4);
        CancelableExecutionRunnable runnable2 = new CancelableExecutionRunnable(periodicTask2, 4);
        CancelableExecutionRunnable runnable3 = new CancelableExecutionRunnable(periodicTask3, 4);
        CancelableExecutionRunnable runnable4 = new CancelableExecutionRunnable(periodicTask4, 4);
        runnable.runNTimes(sch, 5, TimeUnit.SECONDS);
        runnable2.runNTimes(sch, 5, TimeUnit.SECONDS);
        runnable3.runNTimes(sch, 5, TimeUnit.SECONDS);
        runnable4.runNTimes(sch, 5, TimeUnit.SECONDS);

    }
}

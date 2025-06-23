package com.TaskScheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AlarmApp {
    public static void main(String[] args) {
        Runnable alarm = new Runnable() {
            @Override
            public void run() {
                Alarm alarm = new Alarm();
                alarm.setAlarm();
            }
        };

        var executor = Executors.newScheduledThreadPool(2);
        executor.scheduleWithFixedDelay(alarm, 2, 10, TimeUnit.SECONDS);


        try {
            Thread.sleep(200000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();

    }
}

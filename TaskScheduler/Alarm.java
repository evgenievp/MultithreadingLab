package com.TaskScheduler;
import java.time.LocalDateTime;

public class Alarm {
    public Alarm() {
    }

    public void setAlarm() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Alarm rings " + now);
    }

}

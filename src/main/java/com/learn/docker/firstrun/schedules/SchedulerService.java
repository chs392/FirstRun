package com.learn.docker.firstrun.schedules;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class SchedulerService {

    @Scheduled(cron = "1 * * * * *")
    public void displayDateAndMsg() {
        System.out.println("Current time is :: " + Calendar.getInstance().getTime());
    }
}

package com.httt.client.model;

import java.util.Timer;
import java.util.TimerTask;

public class CustomTimer {

    private Timer timer;
    private long millisRemaining;
    private long totalDuration;
    private TimerTask task;
    private double progress;
    private boolean isRunning;

    public CustomTimer(long millis) {
        this.totalDuration = millis;
        this.millisRemaining = millis;
        this.timer = new Timer();
        this.progress = 0.0;
    }

    public void start() {
        isRunning = true;
        task = new TimerTask() {
            @Override
            public void run() {
                millisRemaining -= 10; // decrement by 10ms for better precision
                progress = (double) (totalDuration - millisRemaining) / totalDuration;
                if (millisRemaining <= 0) {
                    stop();

                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 10); // run task every 10ms
    }

    public void stop() {
        task.cancel();
        task = null;
        isRunning = false;
    }

    public long getMillisRemaining() {
        return millisRemaining;
    }

    public void setMillisRemaining(long millis) {
        this.millisRemaining = millis;
        this.totalDuration = millis;
        this.progress = 0.0;
    }

    public double getProgress() {
        return progress;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}

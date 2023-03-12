package com.httt.client.model;

import java.util.Timer;
import java.util.TimerTask;

public class CustomTimer {
    private Timer timer;
    private int countdownTime;
    private CustomTimerListener listener;
    private int interval;
    private boolean isRunning;
    private CountDownTask task;


    public CustomTimer(int countdownTime, int interval, CustomTimerListener listener) {
        this.countdownTime = countdownTime;
        this.interval = interval;
        this.listener = listener;
    }
    private class CountDownTask implements Runnable {
        private boolean isStopped;

        public void stop() {
            isStopped = true;
        }
        @Override
        public void run() {
            int remainingTime = countdownTime*1000;
            while (remainingTime >= 0 && !isStopped) {
                listener.onCountdownUpdate(remainingTime);
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                remainingTime -= interval;
            }
            if (!isStopped) {
                listener.onCountdownComplete();
            }
            isRunning = false;
        }
    }
    public void start() {
        if (!isRunning) {
            task = new CountDownTask();
            new Thread(task).start();
            isRunning = true;
        }
    }

    public void stop() {
        if (isRunning) {
            task.stop();
            isRunning = false;
        }
    }

    public void reset(int countdownTime) {
        stop();
        this.countdownTime = countdownTime;
        start();
    }
    public interface CustomTimerListener{
        void onCountdownUpdate(int remainingTime);
        void onCountdownComplete();
    }
}

package com.httt.client.model;

import java.util.Timer;
import java.util.TimerTask;

public class CustomTimer {
    private Timer timer;
    private int countdown;
    private CustomTimerListener listener;
    private int period ;

    public CustomTimer(int countdown, CustomTimerListener listener, int period) {
        this.countdown = countdown*1000;
        this.listener = listener;
        this.period = period;
    }

    public void start() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                countdown-=period;

                if (countdown <= 0) {
                    stop();
                    listener.onCountdownComplete();
                } else {
                    listener.onCountdownUpdate(countdown);
                }
            }
        }, 0, period);
    }

    public void stop() {
        timer.cancel();
    }

    public interface CustomTimerListener{
        void onCountdownUpdate(int secondsLeft);
        void onCountdownComplete();
    }
}

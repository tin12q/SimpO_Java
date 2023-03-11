package com.httt.server.control.Server.SerWinPane;

import com.httt.server.model.CustomTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.controls.base.MFXLabeled;

import javafx.scene.control.Label;
import javafx.util.Duration;

import java.io.IOException;

public class speedUpRound extends updateInformation implements CustomTimer.CustomTimerListener {
    @FXML private Label nameOfS1, nameOfS2, nameOfS3, nameOfS4;
    @FXML private Label scoreOfS1, scoreOfS2, scoreOfS3, scoreOfS4,timeLb;
    private static final int TIMER_DURATION_SECONDS = 10;
    private CustomTimer timer;

    private Timeline timeline;

    @FXML private void initialize() {
        super.setName(nameOfS1, nameOfS2, nameOfS3, nameOfS4);
        super.setScores(scoreOfS1, scoreOfS2, scoreOfS3, scoreOfS4);
        //timer
         timer = new CustomTimer(TIMER_DURATION_SECONDS, 10,this);

    }

    @Override
    public void onCountdownUpdate(int milis) {
        Platform.runLater(()->{
            timeLb.setText(String.format("%.2f", (double) milis / 1000));
        });
    }
    public void onCountdownComplete() {
        Platform.runLater(()->{
                timeLb.setText("0.00");

        });
    }
    @FXML private void turn1(ActionEvent event) {
        timer.reset(10);
    }
    /*class TimerThread extends Thread{
        int duration;
        double currentSeconds;

        public double getCurrentSeconds() {
            return currentSeconds;
        }

        public TimerThread(int duration){
            this.duration = duration*1000;
        }
        int timerSeconds = 0;
        @Override
        public void run(){

            timeline = new Timeline(new KeyFrame(Duration.millis(10), event -> {
                timerSeconds+=10;
                currentSeconds = (double) timerSeconds / 1000;
                //System.out.println(currentSeconds);

                    Platform.runLater(()->{
                        synchronized (timeLb){
                            timeLb.setText(String.format("%.2f",currentSeconds));
                        }
                    });

                if(timerSeconds==duration){
                    timeline.stop();
                    timerSeconds=0;
                    //stop timer thread
                    timeline.setCycleCount(0);
                    isRunning = false;
                }// Update the progress bar value
            }));
            timeline.setCycleCount(Timeline.INDEFINITE);
            if (!isRunning) { timeline.play(); isRunning = true; }
            else { timeline.stop(); isRunning = false; }
        }
    }*/

}

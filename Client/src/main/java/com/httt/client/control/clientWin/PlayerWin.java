package com.httt.client.control.clientWin;


import com.httt.client.model.CustomTimer;
import io.github.palexdev.materialfx.controls.MFXProgressBar;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;


import java.io.IOException;

public class PlayerWin {
    @FXML
    private AnchorPane ac1;
    @FXML
    private TextField answerTf;
    @FXML
    private MFXProgressBar timerBar;

    private static final int TIMER_DURATION_SECONDS = 10;
    private Timeline timeline;

    private int timerSeconds = 0;
    @FXML
    protected void initialize() throws IOException {
        loadPage("warmUp",new ActionEvent());
        //TimerThread t1 = new TimerThread(10000);
        //t1.run();


        TimerThread t1 = new TimerThread(10000);
        t1.start();
    }
    class TimerThread extends Thread{
        int duration;
        double currentSeconds;

        public double getCurrentSeconds() {
            return currentSeconds;
        }

        public TimerThread(int duration){
            this.duration = duration;
        }
        @Override
        public void run(){
            timeline = new Timeline(new KeyFrame(Duration.millis(1), event -> {
                timerSeconds++;
                currentSeconds = (double) timerSeconds / 1000;
                System.out.println(currentSeconds);
                timerBar.setProgress((double) timerSeconds / 10000);
                if(timerSeconds==duration){
                    timeline.stop();
                    timerSeconds=0;
                }// Update the progress bar value
            }));
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        }
    }
    private void loadPage(String name, ActionEvent event) {
        try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/httt/client/clientWin/Pane/" + name + ".fxml"));

                AnchorPane newPane = loader.load();
                // Set the loaded FXML file as the content of our main right-side pane
                ac1.getChildren().setAll(newPane);
                //stage.setTitle(name);
                // Reset the anchors
                AnchorPane.setBottomAnchor(newPane, 0.0);
                AnchorPane.setLeftAnchor(newPane, 0.0);
                AnchorPane.setRightAnchor(newPane, 50.0);
                AnchorPane.setTopAnchor(newPane, 0.0);
                System.out.println("Loaded " + name + " page");
                //System.out.println(stage.getTitle());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }








    private String formatTime(int seconds) {
        int minutes = seconds / 60;
        seconds = seconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}
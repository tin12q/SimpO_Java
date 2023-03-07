package com.httt.client.control.clientWin;


import io.github.palexdev.materialfx.controls.MFXProgressBar;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;
import com.httt.client.model.participants;

import javax.swing.plaf.basic.BasicBorders;

public class PlayerWin {
    @FXML
    private AnchorPane ac1;
    @FXML
    private TextField answerTf;
    @FXML
    private MFXProgressBar timerBar;
    @FXML
    private Label s1Lb;
    @FXML
    private Label s2Lb;
    @FXML
    private Label s3Lb;
    @FXML
    private Label s4Lb;
    @FXML
    private Label currentName;
    @FXML
    private Label currentPoint;
    @FXML
    private StackPane st1;

    private static final int TIMER_DURATION_SECONDS = 10;
    private Timeline timeline;

    private int timerSeconds = 0;
    @FXML
    protected void initialize() throws IOException {
        participants.setName(0, "Nguyen Van A");
        participants.setName(1, "Nguyen Van B");
        participants.setName(2, "Nguyen Van C");
        participants.setName(3, "Nguyen Van D");
        participants.setScores(0, 0);
        participants.setScores(1, 0);
        participants.setScores(2, 0);
        participants.setScores(3, 0);
        loadPage("warmUp", new ActionEvent());
        //TimerThread t1 = new TimerThread(10000);
        //t1.run();
        //set name and score
        s1Lb.setText(participants.getName(0)+"     "+participants.getScore(0));
        s2Lb.setText(participants.getName(1)+"     "+participants.getScore(1));
        s3Lb.setText(participants.getName(2)+"     "+participants.getScore(2));
        s4Lb.setText(participants.getName(3)+"     "+participants.getScore(3));
        currentName.setText(participants.getName(0));
        currentPoint.setText(String.valueOf(participants.getScore(0)));

        timerBar.prefWidthProperty().bind(st1.heightProperty());

        TimerThread t1 = new TimerThread(20);
        t1.start();
        answerTf.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case ENTER:
                    answerTf.setPromptText("Enter pressed");
                    answerTf.setText("");

                    break;
                case ESCAPE:
                    System.out.println("Escape pressed");
                    break;
                default:
                    break;
            }
        });

    }
    class TimerThread extends Thread{
        int duration;
        double currentSeconds;

        public double getCurrentSeconds() {
            return currentSeconds;
        }

        public TimerThread(int duration){
            this.duration = duration*1000;
        }
        @Override
        public void run(){

            timeline = new Timeline(new KeyFrame(Duration.millis(10), event -> {
                timerSeconds+=10;
                currentSeconds = (double) timerSeconds / 1000;
                System.out.println(currentSeconds);
                timerBar.setProgress((double) timerSeconds / duration);
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
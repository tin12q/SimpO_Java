package com.httt.client.control.clientWin;


import com.httt.client.model.CustomTimer;
import com.httt.client.model.participants;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXProgressBar;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.IOException;


public class PlayerWin implements CustomTimer.CustomTimerListener {
    private static final int TIMER_DURATION_SECONDS = 10;
    public static CustomTimer timer;
    @FXML
    private AnchorPane ac1;
    @FXML
    private TextField answerTf;
    @FXML
    private MFXProgressBar timerBar;
    @FXML
    private MFXButton BELL;
    @FXML
    private Label s1Lb, s2Lb, s3Lb, s4Lb, currentName, currentPoint;
    @FXML
    private StackPane st1;
    @FXML
    private ScrollPane ansSPane;
    @FXML
    private VBox ansList;
    private double estimatedTime = 0;

    @FXML
    protected void initialize() {

        //Async.init();
        participants.setScores(0, 0);
        participants.setName(0, "Nguyen Van A");
        participants.setScores(1, 0);
        participants.setName(1, "Nguyen Van B");
        participants.setScores(2, 0);
        participants.setName(2, "Nguyen Van C");
        participants.setScores(3, 0);
        participants.setName(3, "Nguyen Van D");


        //set name and score
        s1Lb.setText(participants.getName(0) + "     " + participants.getScore(0));
        s2Lb.setText(participants.getName(1) + "     " + participants.getScore(1));
        s3Lb.setText(participants.getName(2) + "     " + participants.getScore(2));
        s4Lb.setText(participants.getName(3) + "     " + participants.getScore(3));
        currentName.setText(participants.getName(0));
        currentPoint.setText(String.valueOf(participants.getScore(0)));
        checkPoint t2 = new checkPoint();
        t2.start();

        //set size
        timerBar.prefWidthProperty().bind(st1.heightProperty());

        //key bind
        answerTf.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case ENTER -> {
                    answerTf.setPromptText("Enter pressed");
                    ansList.getChildren().add(answerLb(answerTf.getText() + " " + String.format("%.2f", estimatedTime)));
                    answerTf.setText("");
                    participants.changePoint(0, 1);
                    //System.out.println(participants.getScore(0));
                    ansSPane.setVvalue(1);
                }
                case ESCAPE -> System.out.println("Escape pressed");
                default -> {
                }
            }
        });

        //TimerThread t1 = new TimerThread(20);


        //t1.start();
        timer = new CustomTimer(TIMER_DURATION_SECONDS, 30, this);
        loadPane("obstacle", new ActionEvent());

        //timer.start();

    }

    @Override
    public void onCountdownUpdate(int remainingMilis, int estimatedMilis) {
        //System.out.println("milis: " + milis);
        Platform.runLater(() -> timerBar.setProgress((double) remainingMilis / (TIMER_DURATION_SECONDS * 1000)));
        estimatedTime = (float) estimatedMilis / 1000;
    }

    @Override
    public void onCountdownComplete() {
        Platform.runLater(() -> timerBar.setProgress(0));
        estimatedTime = 0;
    }

    private void loadPane(String name, ActionEvent event) {
        try {
            if(name.equals("speedUp") || name.equals("warmUp")){
                BELL.setVisible(false);
            }
            else{
                BELL.setVisible(true);
            }
            if(name.equals("warmUp")||name.equals("finish")){
                ansSPane.setVisible(false);
            }
            else {
                ansSPane.setVisible(true);
            }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/httt/client/clientWin/Pane/" + name + ".fxml"));

            AnchorPane newPane = loader.load();
            // Set the loaded FXML file as the content of our main right-side pane
            ac1.getChildren().setAll(newPane);
            //stage.setTitle(name);
            // Reset the anchors
            AnchorPane.setBottomAnchor(newPane, 0.0);
            AnchorPane.setLeftAnchor(newPane, 0.0);
            AnchorPane.setRightAnchor(newPane, 0.0);
            AnchorPane.setTopAnchor(newPane, 0.0);
            System.out.println("Loaded " + name + " page");
            //System.out.println(stage.getTitle());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Label answerLb(String answer) {
        Label lb = new Label();
        lb.setPrefWidth(200);
        lb.setPrefHeight(30);
        //set css class
        lb.getStyleClass().add("answerLb");
        lb.setText(answer);
        return lb;
    }

    private String formatTime(int seconds) {
        int minutes = seconds / 60;
        seconds = seconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    class checkPoint extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    if (participants.getScore(0) != Integer.parseInt(currentPoint.getText())) {
                        Platform.runLater(() -> currentPoint.setText(String.valueOf(participants.getScore(0))));
                        Platform.runLater(() -> s1Lb.setText(participants.getName(0) + "     " + participants.getScore(0)));
                        //System.out.println("change");
                    }
                    Thread.sleep(300);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
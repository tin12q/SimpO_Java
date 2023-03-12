package com.httt.client.control.clientWin;


import com.httt.client.model.CustomTimer;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXProgressBar;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebHistory;
import javafx.util.Duration;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import com.httt.client.model.participants;
import com.ea.async.Async;

import static javafx.scene.input.KeyCode.ENTER;


public class PlayerWin implements CustomTimer.CustomTimerListener {
    @FXML private AnchorPane ac1;
    @FXML private TextField answerTf;
    @FXML private MFXProgressBar timerBar;
    @FXML private MFXButton BELL;
    @FXML private Label s1Lb,s2Lb,s3Lb,s4Lb,currentName,currentPoint;
    @FXML private StackPane st1;
    @FXML private ScrollPane ansSPane;

    @FXML private VBox ansList;
    private static final int TIMER_DURATION_SECONDS = 10;
    private Timeline timeline;
    public static CustomTimer timer;

    private int timerSeconds = 0;
    @FXML
    protected void initialize() throws IOException {

        //Async.init();
        participants.setScores(0, 0);participants.setName(0, "Nguyen Van A");
        participants.setScores(1, 0);participants.setName(1, "Nguyen Van B");
        participants.setScores(2, 0);participants.setName(2, "Nguyen Van C");
        participants.setScores(3, 0);participants.setName(3, "Nguyen Van D");



        //set name and score
        s1Lb.setText(participants.getName(0)+"     "+participants.getScore(0));
        s2Lb.setText(participants.getName(1)+"     "+participants.getScore(1));
        s3Lb.setText(participants.getName(2)+"     "+participants.getScore(2));
        s4Lb.setText(participants.getName(3)+"     "+participants.getScore(3));
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
                    ansList.getChildren().add(answerLb(answerTf.getText()));
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
        timer = new CustomTimer(TIMER_DURATION_SECONDS, 30,this);
        loadPane("speedUp",new ActionEvent());

        //timer.start();

    }
    @Override
    public void onCountdownUpdate(int milis) {
        //System.out.println("milis: " + milis);
        Platform.runLater(()->timerBar.setProgress((double) milis / (TIMER_DURATION_SECONDS*1000)));
    }

    @Override
    public void onCountdownComplete() {
        Platform.runLater(()->timerBar.setProgress(0));
    }
    class checkPoint extends Thread{
        @Override
        public void run(){
            try{
                while (true){
                    if(participants.getScore(0)!=Integer.parseInt(currentPoint.getText())){
                        Platform.runLater(() -> currentPoint.setText(String.valueOf(participants.getScore(0))));
                        Platform.runLater(() -> s1Lb.setText(participants.getName(0)+"     "+participants.getScore(0)));
                        //System.out.println("change");
                    }
                    Thread.sleep(300);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void loadPane(String name, ActionEvent event) {
        try {
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
    private Label answerLb(String answer){
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
}
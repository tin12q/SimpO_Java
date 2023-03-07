package com.httt.client.control.clientWin;


import io.github.palexdev.materialfx.controls.MFXProgressBar;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
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
    @FXML
    protected void initialize() throws IOException {

        Thread t1 = new Thread(new Timer(TIMER_DURATION_SECONDS));
        t1.start();
        loadPage("warmUp", new ActionEvent());

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






    class Timer implements Runnable {
        private int seconds;
        public Timer(int seconds) {
            this.seconds = seconds;
        }
        private int d = 0;
        @Override
        public void run(){
            try {
                while (d < 10000) {
                    d+=50;
                    Thread.sleep(50);
                    Platform.runLater(() -> timerBar.setProgress((double)d/10000));
                    System.out.println((double)d/1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    private String formatTime(int seconds) {
        int minutes = seconds / 60;
        seconds = seconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}
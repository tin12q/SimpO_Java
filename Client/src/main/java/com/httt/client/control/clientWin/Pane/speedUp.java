package com.httt.client.control.clientWin.Pane;

import com.httt.client.control.clientWin.PlayerWin;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class speedUp {
    @FXML
    private Label questionLb;
    @FXML
    private MediaView mediaV;
    @FXML
    private ImageView imgV;

    @FXML
    private AnchorPane speedUpPane;

    @FXML
    private void initialize() {

        questionLb.setText("Question: ");
        Media media = new Media("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4");
        Image img = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/Letter_a.svg/997px-Letter_a.svg.png");
        mediaV.setMediaPlayer(new MediaPlayer(media));
        mediaV.getMediaPlayer().setOnReady(() -> {
            play();
            PlayerWin.timer.reset(10);
            PlayerWin.timer.start();
        });
        //imgV.setImage(img);
        //mediaV.setVisible(false);

    }

    public void play() {
        Platform.runLater(() -> {
            mediaV.getMediaPlayer().play();
        });
    }


}

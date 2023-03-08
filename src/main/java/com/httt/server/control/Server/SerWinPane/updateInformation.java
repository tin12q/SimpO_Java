package com.httt.server.control.Server.SerWinPane;

import javafx.application.Platform;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
public class updateInformation {
    Participants participants = new Participants();
    public void setName(Label nameOfS1, Label nameOfS2, Label nameOfS3, Label nameOfS4) {
        Platform.runLater(()->{
            nameOfS1.setText(participants.getName(0)); nameOfS2.setText(participants.getName(1));
            nameOfS3.setText(participants.getName(2)); nameOfS4.setText(participants.getName(3));
        });
        nameOfS1.setText(participants.getName(0)); nameOfS2.setText(participants.getName(1));
        nameOfS3.setText(participants.getName(2)); nameOfS4.setText(participants.getName(3));
    }

    public void setName(MFXTextField nameOfS1, MFXTextField nameOfS2, MFXTextField nameOfS3, MFXTextField nameOfS4) {
        nameOfS1.setText(participants.getName(0)); nameOfS2.setText(participants.getName(1));
        nameOfS3.setText(participants.getName(2)); nameOfS4.setText(participants.getName(3));
    }

    public void setScores(Label scoreOfS1, Label scoreOfS2, Label scoreOfS3, Label scoreOfS4) {
        Platform.runLater(()->{
            scoreOfS1.setText(String.valueOf(participants.getScore(0)));
            scoreOfS2.setText(String.valueOf(participants.getScore(1)));
            scoreOfS3.setText(String.valueOf(participants.getScore(2)));
            scoreOfS4.setText(String.valueOf(participants.getScore(3)));
        });
        scoreOfS1.setText(String.valueOf(participants.getScore(0)));
        scoreOfS2.setText(String.valueOf(participants.getScore(1)));
        scoreOfS3.setText(String.valueOf(participants.getScore(2)));
        scoreOfS4.setText(String.valueOf(participants.getScore(3)));
    }

    public void setScores(MFXTextField scoreOfS1, MFXTextField scoreOfS2, MFXTextField scoreOfS3, MFXTextField scoreOfS4) {
        scoreOfS1.setText(String.valueOf(participants.getScore(0)));
        scoreOfS2.setText(String.valueOf(participants.getScore(1)));
        scoreOfS3.setText(String.valueOf(participants.getScore(2)));
        scoreOfS4.setText(String.valueOf(participants.getScore(3)));
    }

    public void updateScore(int index, Label scoreOfS1, Label scoreOfS2, Label scoreOfS3, Label scoreOfS4) {
        Platform.runLater(()->{
            switch (index) {
                case 0: scoreOfS1.setText(String.valueOf(participants.getScore(0)));
                case 1: scoreOfS2.setText(String.valueOf(participants.getScore(1)));
                case 2: scoreOfS3.setText(String.valueOf(participants.getScore(2)));
                case 3: scoreOfS4.setText(String.valueOf(participants.getScore(3)));
            }
        });
        switch (index) {
            case 0: scoreOfS1.setText(String.valueOf(participants.getScore(0)));
            case 1: scoreOfS2.setText(String.valueOf(participants.getScore(1)));
            case 2: scoreOfS3.setText(String.valueOf(participants.getScore(2)));
            case 3: scoreOfS4.setText(String.valueOf(participants.getScore(3)));
        }
    }
}

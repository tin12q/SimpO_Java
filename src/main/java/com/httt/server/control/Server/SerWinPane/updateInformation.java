package com.httt.server.control.Server.SerWinPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class updateInformation {
    Participants participants = new Participants();
    public void setInformation(Label nameOfS1, Label nameOfS2, Label nameOfS3, Label nameOfS4,
                               Label scoreOfS1, Label scoreOfS2, Label scoreOfS3, Label scoreOfS4) throws IOException {
        nameOfS1.setText(participants.getName(0)); nameOfS2.setText(participants.getName(1));
        nameOfS3.setText(participants.getName(2)); nameOfS4.setText(participants.getName(3));

        scoreOfS1.setText(String.valueOf(participants.getScore(0)));
        scoreOfS2.setText(String.valueOf(participants.getScore(1)));
        scoreOfS3.setText(String.valueOf(participants.getScore(2)));
        scoreOfS4.setText(String.valueOf(participants.getScore(3)));
    }

    public void updateScore(int index, Label scoreOfS1, Label scoreOfS2, Label scoreOfS3, Label scoreOfS4) {
        switch (index) {
            case 0: scoreOfS1.setText(String.valueOf(participants.getScore(0)));
            case 1: scoreOfS2.setText(String.valueOf(participants.getScore(1)));
            case 2: scoreOfS3.setText(String.valueOf(participants.getScore(2)));
            case 3: scoreOfS4.setText(String.valueOf(participants.getScore(3)));
        }
    }
}

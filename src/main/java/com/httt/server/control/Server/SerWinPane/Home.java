package com.httt.server.control.Server.SerWinPane;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.awt.*;
import java.io.IOException;

public class Home extends displayParticipants {
    @FXML private MFXTextField nameOfS1, nameOfS2, nameOfS3, nameOfS4;
    @FXML private MFXTextField scoreOfS1, scoreOfS2, scoreOfS3, scoreOfS4;
    Participants participants = new Participants();
    @FXML private void changeDetails(ActionEvent event) throws IOException {
        String names[] = new String[4];
        names[0] = nameOfS1.getText(); names[1] = nameOfS2.getText();
        names[2] = nameOfS3.getText(); names[3] = nameOfS4.getText();
        participants.setName(0, names[0]); participants.setName(1, names[1]);
        participants.setName(2, names[2]); participants.setName(3, names[3]);

        int scores[] = new int[4];
        scores[0] = Integer.parseInt(scoreOfS1.getText());  scores[1] = Integer.parseInt(scoreOfS2.getText());
        scores[2] = Integer.parseInt(scoreOfS3.getText());  scores[3] = Integer.parseInt(scoreOfS4.getText());
        participants.setScores(0, scores[0]); participants.setScores(1, scores[1]);
        participants.setScores(2, scores[2]); participants.setScores(3, scores[3]);

//        System.out.println(participants.getName(0) + " " + participants.getScore(0));
//        System.out.println(participants.getName(1) + " " + participants.getScore(1));
//        System.out.println(participants.getName(2) + " " + participants.getScore(2));
//        System.out.println(participants.getName(3) + " " + participants.getScore(3));
    }
}

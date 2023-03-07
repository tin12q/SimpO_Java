package com.httt.server.control.Server.SerWinPane;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.controls.base.MFXLabeled;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import java.io.IOException;

public class warmUpRound extends updateInformation {
    @FXML private Label nameOfS1, nameOfS2, nameOfS3, nameOfS4;
    @FXML private Label scoreOfS1, scoreOfS2, scoreOfS3, scoreOfS4;
    Participants participants = new Participants();
    @FXML private void initialize() {
        System.out.println(1);
        super.setName(nameOfS1, nameOfS2, nameOfS3, nameOfS4);
        super.setScores(scoreOfS1, scoreOfS2, scoreOfS3, scoreOfS4);
    }

    int turnID = 0;
    @FXML private void changeTurn1(ActionEvent event) throws IOException {turnID = 0;}
    @FXML private void changeTurn2(ActionEvent event) throws IOException {turnID = 1;}
    @FXML private void changeTurn3(ActionEvent event) throws IOException {turnID = 2;}
    @FXML private void changeTurn4(ActionEvent event) throws IOException {turnID = 3;}

    @FXML private void correctAnswer(ActionEvent event) throws IOException {
        participants.changePoint(turnID, 10);
        updateScore(turnID, scoreOfS1, scoreOfS2, scoreOfS3, scoreOfS4);
    }

    @FXML private void wrongAnswer(ActionEvent event) throws IOException {
        participants.changePoint(turnID, -5);
        updateScore(turnID, scoreOfS1, scoreOfS2, scoreOfS3, scoreOfS4);
    }
}

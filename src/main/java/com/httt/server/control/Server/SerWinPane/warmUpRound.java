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
    @FXML private void setUp(ActionEvent event) throws IOException {
        super.setInformation(nameOfS1, nameOfS2, nameOfS3, nameOfS4, scoreOfS1, scoreOfS2, scoreOfS3, scoreOfS4);
    }

    int turnID = 0;
    @FXML private void changeTurn1() {turnID = 0;}
    @FXML private void changeTurn2() {turnID = 1;}
    @FXML private void changeTurn3() {turnID = 2;}
    @FXML private void changeTurn4() {turnID = 3;}

    @FXML private void correctAnswer() {
        participants.changePoint(turnID, 10);
        updateScore(turnID, scoreOfS1, scoreOfS2, scoreOfS3, scoreOfS4);
    }

    @FXML private void wrongAnswer() {
        participants.changePoint(turnID, -5);
        updateScore(turnID, scoreOfS1, scoreOfS2, scoreOfS3, scoreOfS4);
    }
}

package com.httt.server.control.Server.SerWinPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.controls.base.MFXLabeled;

import javafx.scene.control.Label;
import java.io.IOException;

public class speedUpRound extends updateInformation{
    @FXML private Label nameOfS1, nameOfS2, nameOfS3, nameOfS4;
    @FXML private Label scoreOfS1, scoreOfS2, scoreOfS3, scoreOfS4;
    @FXML private void initialize() {
        participants.setName(0, "Nguyen Van A");
        participants.setName(1, "Nguyen Van B");
        participants.setName(2, "Nguyen Van C");
        participants.setName(3, "Nguyen Van D");
        participants.setScores(0, 0);
        participants.setScores(1, 0);
        participants.setScores(2, 0);
        participants.setScores(3, 0);
        super.setName(nameOfS1, nameOfS2, nameOfS3, nameOfS4);
        super.setScores(scoreOfS1, scoreOfS2, scoreOfS3, scoreOfS4);
    }
}

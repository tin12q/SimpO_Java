package com.httt.server.control.Server.SerWinPane;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class tieBreakRound extends updateInformation {
    @FXML private Label nameOfS1, nameOfS2, nameOfS3, nameOfS4;
    @FXML private Label scoreOfS1, scoreOfS2, scoreOfS3, scoreOfS4;
    @FXML private void initialize() {
        super.setName(nameOfS1, nameOfS2, nameOfS3, nameOfS4);
        super.setScores(scoreOfS1, scoreOfS2, scoreOfS3, scoreOfS4);
    }
}

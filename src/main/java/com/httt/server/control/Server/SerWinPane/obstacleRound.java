package com.httt.server.control.Server.SerWinPane;

import io.github.palexdev.materialfx.controls.MFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.io.IOException;

public class obstacleRound extends updateInformation {
    @FXML private Label nameOfS1, nameOfS2, nameOfS3, nameOfS4;
    @FXML private Label nameOfS11, nameOfS22, nameOfS33, nameOfS44;
    @FXML private Label scoreOfS1, scoreOfS2, scoreOfS3, scoreOfS4;
    @FXML private MFXRadioButton checkS1, checkS2, checkS3, checkS4;

    @FXML private void initialize() {
        super.setName(nameOfS1, nameOfS2, nameOfS3, nameOfS4);
        super.setName(nameOfS11, nameOfS22, nameOfS33, nameOfS44);
        super.setScores(scoreOfS1, scoreOfS2, scoreOfS3, scoreOfS4);
    }

    private void processAnswerOfContestant(int id, MFXRadioButton check) {
        if (check.isSelected())
            participants.changePoint(id, 10);
    }
    
    @FXML private void processAnswers() {
        processAnswerOfContestant(0, checkS1);
        processAnswerOfContestant(1, checkS2);
        processAnswerOfContestant(2, checkS3);
        processAnswerOfContestant(3, checkS4);
        for (int i = 0; i < 4; i++)
            updateScore(i, scoreOfS1, scoreOfS2, scoreOfS3, scoreOfS4);
    }
}

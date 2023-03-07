package com.httt.server.control.Server.SerWinPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.controls.base.MFXLabeled;

import javafx.scene.control.Label;
import java.io.IOException;

public class obstacleRound extends updateInformation{
    @FXML private Label nameOfS1, nameOfS2, nameOfS3, nameOfS4;
    @FXML private Label nameOfS11, nameOfS22, nameOfS33, nameOfS44;
    @FXML private Label scoreOfS1, scoreOfS2, scoreOfS3, scoreOfS4;
    @FXML private void initialize() {
        super.setName(nameOfS1, nameOfS2, nameOfS3, nameOfS4);
        super.setName(nameOfS11, nameOfS22, nameOfS33, nameOfS44);
        super.setScores(scoreOfS1, scoreOfS2, scoreOfS3, scoreOfS4);
    }
}

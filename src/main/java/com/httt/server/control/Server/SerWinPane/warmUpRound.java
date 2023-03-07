package com.httt.server.control.Server.SerWinPane;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.awt.*;
import java.io.IOException;

public class warmUpRound {
    @FXML private Label nameOfS1, nameOfS2, nameOfS3, nameOfS4;
    @FXML private Label scoreOfS1, scoreOfS2, scoreOfS3, scoreOfS4;
    Participants participants = new Participants();
    @FXML private void setUp(ActionEvent event) throws IOException {
        System.out.println(1);
//        nameOfS1.setText(participants.getName(0));
//        nameOfS2.setText(participants.getName(1));
//        nameOfS3.setText(participants.getName(2)); nameOfS4.setText(participants.getName(3));
    }
}

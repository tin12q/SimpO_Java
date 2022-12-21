package com.httt.server.control.Server.SerWinPane;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Start {
    @FXML
    private MFXButton btn1;

    @FXML
    private void initialize() {
        btn1.setOnAction(event -> loadPage("Stuff",event));
    }

    private void loadPage(String stuff, ActionEvent event) {
        btn1.setText(stuff);
    }
}

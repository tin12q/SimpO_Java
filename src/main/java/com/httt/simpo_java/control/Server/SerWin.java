package com.httt.simpo_java.control.Server;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SerWin {

    @FXML
    private Label IP;

    @FXML
    private MFXButton startbtn;

    @FXML
    void Start(ActionEvent event) {
        IP.setText("IP: "+new IpGet().getHostIP());
    }

}

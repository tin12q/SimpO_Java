package com.httt.simpo_java.control.Server;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SerWin {

    @FXML
    private Label IP;

    @FXML
    private Label IP1;

    @FXML
    private AnchorPane ac1;

    @FXML
    private AnchorPane ac2;

    @FXML
    private MFXButton obstabtn;

    @FXML
    private MFXButton startbtn;

    @FXML
    private MFXButton stuffbtn;

    @FXML
    void Start(ActionEvent event) {
        IP.setText("IP: "+new IpGet().getHostIP());
    }



    @FXML
    private void initialize() {

        stuffbtn.setOnAction(event -> loadPage("Stuff"));
        obstabtn.setOnAction(event -> loadPage("Obsta"));
        startbtn.setOnAction(event -> loadPage("Start"));

    }
    private void loadPage(String name) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/httt/simpo_java/Server/SerWinPane/"+name + ".fxml"));

            AnchorPane newPane = loader.load();

            // Set the loaded FXML file as the content of our main right-side pane
            ac1.getChildren().setAll(newPane);

            // Reset the anchors
            AnchorPane.setBottomAnchor(newPane, 0.0);
            AnchorPane.setLeftAnchor(newPane, 0.0);
            AnchorPane.setRightAnchor(newPane, 0.0);
            AnchorPane.setTopAnchor(newPane, 0.0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

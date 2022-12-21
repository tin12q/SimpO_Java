package com.httt.simpo_java.control.Server;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    private MFXButton accelbtn;

    @FXML
    private MFXButton finishbtn;

    @FXML
    private MFXButton initbutton;

    @FXML
    private MFXButton obstabtn;

    @FXML
    private MFXButton startbtn;

    @FXML
    private MFXButton stuffbtn;

    @FXML
    private MFXButton tiebtn;

    @FXML
    void Start(ActionEvent event) {
        IP.setText("IP: "+new IpGet().getHostIP());
    }



    @FXML
    private void initialize() {

        stuffbtn.setOnAction(event -> loadPage("Stuff",event));
        obstabtn.setOnAction(event -> loadPage("Obsta",event));
        startbtn.setOnAction(event -> loadPage("Start",event));
        accelbtn.setOnAction(event -> loadPage("Accel",event));
        tiebtn.setOnAction(event -> loadPage("Tie", event));
        finishbtn.setOnAction(event -> loadPage("Finish", event));

    }
    private void loadPage(String name,ActionEvent event) {

        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            if(stage.getTitle().equals(name))
            {
                return;
            }
            else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/httt/simpo_java/Server/SerWinPane/"+name + ".fxml"));

                AnchorPane newPane = loader.load();

                // Set the loaded FXML file as the content of our main right-side pane
                ac1.getChildren().setAll(newPane);

                stage.setTitle(name);
                // Reset the anchors
                AnchorPane.setBottomAnchor(newPane, 0.0);
                AnchorPane.setLeftAnchor(newPane, 0.0);
                AnchorPane.setRightAnchor(newPane, 0.0);
                AnchorPane.setTopAnchor(newPane, 0.0);
                System.out.println("Loaded " + name + " page");
                System.out.println(stage.getTitle());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

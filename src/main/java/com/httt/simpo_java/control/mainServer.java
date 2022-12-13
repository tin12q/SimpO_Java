package com.httt.simpo_java.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;



public class mainServer {

    @FXML
    private Button lamDe;

    @FXML
    private Button server;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void lamDeClick(ActionEvent event) {

    }

    @FXML
    void serverClick(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("serverWindow.fxml"));
        Stage window = (Stage) server.getScene().getWindow();
        window.setScene(new Scene(root));
    }

}

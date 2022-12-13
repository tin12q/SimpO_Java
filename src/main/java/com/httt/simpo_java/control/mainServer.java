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
import java.util.Objects;


public class mainServer {

    @FXML
    private Button lamDe;

    @FXML
    private Button server;


    @FXML
    void lamDeClick(ActionEvent event) {

    }

    @FXML
    void serverClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/httt/simpo_java/Server/serverWindow.fxml"));
        Parent content = loader.load();

        Scene scene = new Scene(content);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

}

package com.httt.server;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @FXML
    private MFXButton lamDe;

    @FXML
    private MFXButton server;

    @FXML
    void lamDeClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/httt/server/ExamMaker/examMaker.fxml"));
        Parent content = loader.load();

        Scene scene = new Scene(content);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.setX(0);
        stage.setY(0);
        stage.setTitle("Exam Maker");
        stage.show();
    }
    @FXML
    void serverClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/httt/server/Server/SerWin.fxml"));
        Parent content = loader.load();

        Scene scene = new Scene(content);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.setX(0);
        stage.setY(0);
        stage.setTitle("Server");
        stage.show();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("mainServer.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Main");
        stage.sizeToScene();
        stage.show();
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        launch();
    }
}
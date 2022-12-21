package com.httt.client.control;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class MainClient {

    @FXML
    private MFXButton clientBtn;

    @FXML
    private MFXButton diemBtn;

    @FXML
    private MFXButton mcBtn;

    @FXML
    private MFXButton viewerBtn;
    @FXML
    private void initialize() throws IOException {

        clientBtn.setOnAction(event -> {
            try {
                loadPage("/clientWin/clientWin",event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        diemBtn.setOnAction(event -> {
            try {
                loadPage("/diemWin/diemtWin",event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        mcBtn.setOnAction(event -> {
            try {
                loadPage("/mcWin/mcWin",event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        mcBtn.setOnAction(event -> {
            try {
                loadPage("/mcWin/mcWin",event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        viewerBtn.setOnAction(event -> {
            try {
                loadPage("/viewerWin/viewerWin",event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


    }

    private void loadPage(String page, ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/httt/client"+page+".fxml"));
        Parent content = loader.load();

        Scene scene = new Scene(content);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.setX(0);
        stage.setY(0);
        stage.setTitle("Server");
        stage.show();
    }

}

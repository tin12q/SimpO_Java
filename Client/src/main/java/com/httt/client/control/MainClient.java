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

        viewerBtn.setOnAction(event ->loadPage("/viewerWin/viewerWin",event));
        clientBtn.setOnAction(event ->loadPage("/clientWin/playerWin",event));
        diemBtn.setOnAction(event -> loadPage("/diemWin/diemWin",event));
        mcBtn.setOnAction(event -> loadPage("/mcWin/mcWin",event));
        mcBtn.setOnAction(event -> loadPage("/mcWin/mcWin",event));
        viewerBtn.setOnAction(event -> loadPage("/viewerWin/viewerWin",event));



    }

    private void loadPage(String page, ActionEvent event)  {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/httt/client"+page+".fxml"));
            Parent content = loader.load();

            Scene scene = new Scene(content);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);
            stage.setX(0);
            stage.setY(0);
            stage.setTitle("Client");
            stage.show();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

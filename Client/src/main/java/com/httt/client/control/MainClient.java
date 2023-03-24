package com.httt.client.control;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;

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
        viewerBtn.setOnAction(event -> loadPage("/viewerWin/viewerWin", event));
        clientBtn.setOnAction(event -> loadPage("/clientWin/playerWin", event));
        diemBtn.setOnAction(event -> loadPage("/diemWin/diemWin", event));
        mcBtn.setOnAction(event -> loadPage("/mcWin/mcWin", event));
    }

    private void loadPage(String page, ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/httt/client" + page + ".fxml"));
            Parent content = loader.load();

            Scene scene = new Scene(content);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            //setFullScreen;

            stage.setScene(scene);
            stage.show();
            //fullScreen exit button on f12
            stage.setFullScreenExitHint("");
            KeyCombination customExitCombo = new KeyCodeCombination(KeyCode.F12, KeyCombination.SHIFT_ANY);
            stage.setFullScreenExitKeyCombination(customExitCombo);
            stage.setFullScreen(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

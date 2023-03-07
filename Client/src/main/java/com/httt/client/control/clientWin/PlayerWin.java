package com.httt.client.control.clientWin;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;

public class PlayerWin {
    @FXML
    private AnchorPane ac1;
    @FXML
    private TextField answerTf;
    @FXML
    protected void initialize() throws IOException {
        loadPage("KD", new ActionEvent());

    }

    private void loadPage(String name, ActionEvent event) {
        try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/httt/client/clientWin/Pane/" + name + ".fxml"));

                AnchorPane newPane = loader.load();
                // Set the loaded FXML file as the content of our main right-side pane
                ac1.getChildren().setAll(newPane);
                //stage.setTitle(name);
                // Reset the anchors
                AnchorPane.setBottomAnchor(newPane, 0.0);
                AnchorPane.setLeftAnchor(newPane, 0.0);
                AnchorPane.setRightAnchor(newPane, 50.0);
                AnchorPane.setTopAnchor(newPane, 0.0);
                System.out.println("Loaded " + name + " page");
                //System.out.println(stage.getTitle());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package com.httt.client.control.clientWin.Pane;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


public class warmUp {
    @FXML private Label questionLb;
    @FXML private ImageView imgV;
    @FXML private AnchorPane aP;

    @FXML
    protected void initialize() {
        questionLb.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book." +
                " It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing " +
                "software like Aldus PageMaker including versions of Lorem Ipsum");
        Image img = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/Letter_a.svg/997px-Letter_a.svg.png");
        imgV.setImage(img);

        aP.getChildren().add(imgV);
    }

}

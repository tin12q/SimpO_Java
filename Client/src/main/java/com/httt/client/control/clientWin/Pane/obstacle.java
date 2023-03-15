package com.httt.client.control.clientWin.Pane;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class obstacle {
    @FXML private Label questionLb;
    @FXML private ImageView imageView;
    @FXML private AnchorPane obstaclePane;
    private final VBox questionVb = new VBox();
    private Rectangle[] rec = new Rectangle[5];
    private static Question[] questionList = new Question[4];
    @FXML private void initialize() {
        //tạo che
        for(int i=0;i<=4;i++){
           rec[i]=new Rectangle(450,300);
           rec[i].setFill(Color.web("#847577"));
           rec[i].setStroke(Color.web("#FBFBF2"));

           obstaclePane.getChildren().add(rec[i]);

        }
        //che
        AnchorPane.setTopAnchor(rec[0],30.0);AnchorPane.setLeftAnchor(rec[0],233.0);
        AnchorPane.setTopAnchor(rec[1],30.0);AnchorPane.setRightAnchor(rec[1],233.0);
        AnchorPane.setTopAnchor(rec[2],330.0);AnchorPane.setLeftAnchor(rec[2],233.0);
        AnchorPane.setTopAnchor(rec[3],330.0);AnchorPane.setRightAnchor(rec[3],233.0);
        AnchorPane.setTopAnchor(rec[4],180.0);AnchorPane.setRightAnchor(rec[4],233.0+225);
        //question
        questionLb.setText("Question: ");
        //image
        Image img = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/Letter_a.svg/997px-Letter_a.svg.png");
        imageView.setImage(img);
        //question list
        obstaclePane.getChildren().add(questionVb);
        questionVb.setPrefHeight(300); questionVb.setPrefWidth(450);
        questionVb.setSpacing(10);
        questionVb.setAlignment(Pos.CENTER);
        AnchorPane.setTopAnchor(questionVb,180.0);
        AnchorPane.setLeftAnchor(questionVb,233.0+225+30);
        AnchorPane.setRightAnchor(questionVb,233.0+225+30);
        for(int i=0;i<4;i++){
            questionList[i]= new Question("Question " + (i + 1), "Answer " + (i + 1));
            questionVb.getChildren().add(questionList[i].getQuestion());
        }
    }

    static class Question {
        String question;
        String answer;
        public Question(String question, String answer) {
            this.question = question;
            this.answer = answer;
        }
        public HBox getQuestion(){
            HBox questionHb = new HBox();
            questionHb.setSpacing(10);
            for (int i = 0; i < question.length(); i++) {
                Label lb = new Label(question.charAt(i) + "");
                lb.setPrefSize(30, 30);
                lb.setAlignment(Pos.CENTER);
                lb.setStyle("-fx-font-size: 20px;"+"-fx-background-color: #FBFBF2;"+"-fx-text-fill: #847577;"+"-fx-border-radius: 50%;"+"-fx-background-radius: 50%;");
                questionHb.getChildren().add(lb);
            }
            return questionHb;
        }
    }
}

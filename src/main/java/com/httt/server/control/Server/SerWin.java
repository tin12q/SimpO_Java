package com.httt.server.control.Server;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.*;
import java.io.*;


public class SerWin {

    @FXML
    private Label IP;

    @FXML
    private AnchorPane ac1;

    @FXML
    private MFXButton accelbtn;

    @FXML
    private MFXButton finishbtn;

    @FXML
    private MFXButton obstabtn;

    @FXML
    private MFXButton startbtn;

    @FXML
    private MFXButton stuffbtn;

    @FXML
    private MFXButton tiebtn;
    DataInputStream din =null;
    DataOutputStream dout = null;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    @FXML
    void Start(ActionEvent event) {
        initServer init = new initServer();
        init.start();
        send send = new send();
        send.start();
        IP.setText("IP: " + new IpGet().getHostIP());
    }

    @FXML
    private void initialize() {
        stuffbtn.setOnAction(event -> loadPage("Home", event));
        obstabtn.setOnAction(event -> loadPage("obstacleRound", event));
        startbtn.setOnAction(event -> loadPage("warmUpRound", event));
        accelbtn.setOnAction(event -> loadPage("speedUpRound", event));
        tiebtn.setOnAction(event -> loadPage("tieBreakRound", event));
        finishbtn.setOnAction(event -> loadPage("finishRound", event));

    }
    private void loadPage(String name, ActionEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            if(stage.getTitle().equals(name))
            {
                return;
            }
            else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/httt/server/Server/SerWinPane/" + name + ".fxml"));

                AnchorPane newPane = loader.load();

                // Set the loaded FXML file as the content of our main right-side pane
                ac1.getChildren().setAll(newPane);

                stage.setTitle(name);
                // Reset the anchors
                AnchorPane.setBottomAnchor(newPane, 0.0);
                AnchorPane.setLeftAnchor(newPane, 0.0);
                AnchorPane.setRightAnchor(newPane, 0.0);
                AnchorPane.setTopAnchor(newPane, 0.0);
//                System.out.println("Loaded " + name + " page");
//                System.out.println(stage.getTitle());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    class initServer extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                ServerSocket ss = new ServerSocket(3333);
                Socket s = ss.accept();
                String str = "cdef", str2 = "";
                din = new DataInputStream(s.getInputStream());
                dout = new DataOutputStream(s.getOutputStream());

                while (!str.equals("stop")) {
                    str2 = din.readUTF();
                    System.out.println("Client says: " + str2);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    class send extends Thread{
        @Override
        public void run() {
            super.run();
            try {
                String str = "cdef", str2 = "";
                while (!str.equals("stop")) {
                    str = br.readLine();
                    dout.writeUTF(str);
                    dout.flush();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
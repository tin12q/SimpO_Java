package com.httt.server.control.Server;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.*;


public class serverWindow {

    String ip;
    @FXML
    private AnchorPane serWin;
    @FXML
    private Button StartButton;
    @FXML
    private Label Ip;
    @FXML
    private TextField Port_Label;
    private String hostIP;

    @FXML
    void Start(ActionEvent event) throws UnknownHostException, SocketException {
//        ip = InetAddress.getLocalHost().getHostAddress();

        Ip.setText(new IpGet().getHostIP());

    }


}

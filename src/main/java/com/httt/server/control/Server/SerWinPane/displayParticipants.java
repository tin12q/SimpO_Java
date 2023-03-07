package com.httt.server.control.Server.SerWinPane;

import java.awt.*;

public class displayParticipants {
    com.httt.server.control.Server.SerWinPane.Participants Participants;
    TextField nameOfS1TF, nameOfS2TF, nameOfS3TF, nameOfS4TF;
    TextField scoreOfS1TF, scoreOfS2TF, scoreOfS3TF, scoreOfS4TF;
    void display() {
        nameOfS1TF.setText(Participants.getName(0)); nameOfS2TF.setText(Participants.getName(1));
        nameOfS3TF.setText(Participants.getName(2)); nameOfS4TF.setText(Participants.getName(3));
    }
}

package com.httt.server.control.Server.SerWinPane;

public class Participants {
    private static String names[] = new String[4];
    private static int scores[] = new int[4];

    public int getScore(int index) {
        return scores[index];
    }
    public void setScores(int index, int points) {
        scores[index] = points;
    }

    public String getName(int index) {
        return names[index];
    }
    public void setName(int index, String nameOfParticipant) {
        names[index] = nameOfParticipant;
    }

    public void changePoint(int index, int points) {
        scores[index] += points;
        if(scores[index] < 0) scores[index] = 0;
    }
}
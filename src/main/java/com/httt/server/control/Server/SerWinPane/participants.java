package com.httt.server.control.Server.SerWinPane;

public class participants {
    private String names[] = new String[4];
    private int scores[] = new int[4];

    public int getScore(int index) {
        return this.scores[index];
    }
    public void setScores(int index, int points) {
        this.scores[index] = points;
    }

    public String getName(int index) {
        return this.names[index];
    }
    public void setName(int index, String name) {
        this.names[index] = name;
    }

    public void changePoint(int index, int points) {
        this.scores[index] += points;
        if(this.scores[index] < 0) this.scores[index] = 0;
    }
}
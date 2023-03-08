package com.httt.client.model;



public class participants {
    private static String[] names = new String[4];
    private static int[] scores = new int[4];

    public static int getScore(int index) {
        return scores[index];
    }
    public static void setScores(int index, int points) {
        scores[index] = points;
    }

    public static String getName(int index) {
        return names[index];
    }
    public static void setName(int index, String name) {
        names[index] = name;
    }

    public static void changePoint(int index, int points) {
        scores[index] += points;
        if(scores[index] < 0) scores[index] = 0;
    }
}
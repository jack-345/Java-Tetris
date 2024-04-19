package edu.gonzaga;

public class Player {
    int score;
    String name;

    public Player() {
        this.name = "default";
        this.score= 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

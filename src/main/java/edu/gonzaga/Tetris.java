package edu.gonzaga;

import java.io.IOException;

public class Tetris {
    public static void main(String[] args) throws IOException, InterruptedException {
        TetrisGame game = new TetrisGame();
        game.startGame();
    }
}

package edu.gonzaga;

import java.awt.*;
import java.io.IOException;
import java.util.Timer;

public class  Tetris {
    public static void main(String[] args) throws IOException, InterruptedException {
        TetrisGame game=new TetrisGame();

        game.startGame();
    }
}

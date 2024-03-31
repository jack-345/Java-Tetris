package edu.gonzaga;

import java.awt.*;
import java.io.IOException;
import java.util.Timer;
import javax.swing.JFrame;

public class  Tetris {
    public static void main(String[] args) throws IOException, InterruptedException {
        TetrisGame game=new TetrisGame();


        game.startGame();
    }
}

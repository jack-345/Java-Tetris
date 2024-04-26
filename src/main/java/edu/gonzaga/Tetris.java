package edu.gonzaga;
import java.io.IOException;

public class Tetris {
    public static void main(String[] args) throws IOException, InterruptedException {

        //initializing a new instance of our tetris game class which is our main function for running the tetris grid
        TetrisGame game = new TetrisGame();
        //calling start game, a method that creates panels and timers and runs methods on them
        game.startMenu();
    }
}

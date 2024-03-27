package edu.gonzaga;

import java.awt.*;
import java.io.IOException;

public class TetrisGame {
    public TetrisGame(){

    }
    public void startGame() throws IOException, InterruptedException {
        Long timer= System.currentTimeMillis();
        GamePad gamePad=new GamePad(70,50);
        TetroL ter=new TetroL(gamePad.getBlocks(),new Point(5,5));
        gamePad.addATetro(ter);
        ter.addToGameListeners(gamePad);
        while (true){
            if((System.currentTimeMillis()-timer)%500==0) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                ter.step();
            }
        }
    }
}

package edu.gonzaga;

import java.awt.*;
import java.io.IOException;

public class TetrisGame {
    public TetrisGame(){

    }
    public void startGame() throws IOException, InterruptedException {
        Long timer= System.currentTimeMillis();
        GamePad gamePad=new GamePad(10,20);
        while (true) {
            TetroO ter=new TetroO(gamePad.getBlocks(),new Point(5,0));
            gamePad.addATetro(ter);
            ter.addToGameListeners(gamePad);
            while (true) {
                if ((System.currentTimeMillis() - timer) % 500 == 0) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    if (gamePad.movingCheck()[1]) {
                        ter.step();
                    } else {
                        ter.lock();
                        break;
                    }
                }
            }
        }
    }
}

package edu.gonzaga;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.security.Key;
import java.util.Random;

public class TetrisGame {
    public TetrisGame(){

    }
    public void startGame() throws IOException, InterruptedException {
        Long timer= System.currentTimeMillis();
        GamePad gamePad=new GamePad(10,20);
        Random rand=new Random();
        Tetrominoes ter=new TetroO(gamePad.getBlocks(),new Point(5,0));
        //GameControlPanel dialog = new GameControlPanel(gamePad);
        //dialog.pack();
        //dialog.setVisible(true);
        while (true) {
            Integer wter= rand.nextInt(3);
            switch (wter){
                case 0:ter=new TetroO(gamePad.getBlocks(),new Point(5,0));break;
                case 1:ter=new TetroL(gamePad.getBlocks(),new Point(5,0));break;
                case 2:ter=new TetroI(gamePad.getBlocks(),new Point(5,0));break;
            }
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

package edu.gonzaga;

import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class TetrisGame {
    public TetrisGame(){

    }
    public void startGame() throws IOException, InterruptedException {
        Long timer= System.currentTimeMillis();
        GridPad gridPad =new GridPad(10,20);
        Random rand=new Random();
        Block ter=new BlockO(gridPad.getBlocks(),new Point(5,0));
        while (true) {
            Integer wter= rand.nextInt(3);
            switch (wter){
                case 0:ter=new BlockO(gridPad.getBlocks(),new Point(5,0));break;
                case 1:ter=new BlockL(gridPad.getBlocks(),new Point(5,0));break;
                case 2:ter=new BlockI(gridPad.getBlocks(),new Point(5,0));break;
            }
            gridPad.addATetro(ter);
            ter.addToGameListeners(gridPad);
            while (true) {

                if ((System.currentTimeMillis() - timer) % 500 == 0) {
                    //Only for windows command line, not work for idea command line.
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    if (gridPad.movingCheck()[1]) {
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

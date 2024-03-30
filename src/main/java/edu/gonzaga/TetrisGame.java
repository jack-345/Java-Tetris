package edu.gonzaga;

import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class TetrisGame {
    public TetrisGame(){

    }
    public void startGame() throws IOException, InterruptedException {
        //set a timer
        Long timer= System.currentTimeMillis();
        Integer runTime=500;
        GridPad gridPad =new GridPad(10,20);
        Random rand=new Random();
        Block ter=new BlockO(gridPad.getGridBlocks(),new Point(5,0));
        while (true) {
            Integer wter= rand.nextInt(3);
            switch (wter){
                case 0:ter=new BlockO(gridPad.getGridBlocks(),new Point(5,0));break;
                case 1:ter=new BlockL(gridPad.getGridBlocks(),new Point(5,0));break;
                case 2:ter=new BlockI(gridPad.getGridBlocks(),new Point(5,0));break;
            }
            gridPad.addABlock(ter);
            ter.addToGameListeners(gridPad);
            while (true) {

                if ((System.currentTimeMillis() - timer) % runTime == 0) {
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

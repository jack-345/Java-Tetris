package edu.gonzaga;

import java.io.IOException;
import java.util.Timer;

public class  Tetris {
    public static void main(String[] args) throws IOException, InterruptedException {
        Long timer= System.currentTimeMillis();
        GamePad gamePad=new GamePad(70,50);
        TetroO ter=new TetroO(gamePad.getBlocks());
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

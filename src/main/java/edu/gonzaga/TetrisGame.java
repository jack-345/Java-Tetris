package edu.gonzaga;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class TetrisGame {
    private Timer swingTimer;

    public TetrisGame() {

    }

    public void startGame() throws IOException, InterruptedException {
        //set a timer

        Integer runTime = 100;
        GridPad gridPad = new GridPad(20, 40);
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        GridBlockLayer grid = new GridBlockLayer(gridPad);
        gridPad.addGUIListener(grid);
        JFrame application = new JFrame(); // creates a new JFrame
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(grid);
        grid.setSize(200, 400);
        application.setSize(240, 440);
        application.setVisible(true);
        swingTimer = new Timer(500, ev -> {
        });
        while (true) {
            Integer wBlock = rand.nextInt(8);
            Integer spawnX = rand.nextInt(17)+1;
            Integer spawnY=1;
            Integer colorR = rand.nextInt(256);
            Integer colorG = rand.nextInt(256);
            Integer colorB = rand.nextInt(256);
            Integer rotate = rand.nextInt(9)-4;
            if (!swingTimer.isRunning()) {
                System.out.printf("What Block: %d, SpawnX: %d, Rotate: %d\n",wBlock,spawnX,rotate);
                Block ter;
                switch (wBlock) {
                    case 0:
                        ter = new BlockO(gridPad.getGridBlocks(), new Point(spawnX, spawnY));
                        break;
                    case 1:
                        ter = new BlockL(gridPad.getGridBlocks(), new Point(spawnX, spawnY));
                        break;
                    case 2:
                        ter = new BlockI(gridPad.getGridBlocks(), new Point(spawnX, spawnY));
                        break;
                    case 3:
                        ter = new BlockS(gridPad.getGridBlocks(), new Point(spawnX, spawnY));
                        break;
                    case 4:
                        ter = new BlockZ(gridPad.getGridBlocks(), new Point(spawnX, spawnY));
                        break;
                    case 5:
                        ter = new BlockT(gridPad.getGridBlocks(), new Point(spawnX, spawnY));
                        break;
                    default:
                        ter = new BlockJ(gridPad.getGridBlocks(), new Point(spawnX, spawnY));
                        break;
                }
                ter.setColor(new Color(colorR,colorG,colorB));
                ter.rotate(rotate);
               // Long timer = System.currentTimeMillis();
                gridPad.addABlock(ter);
                ter.addToGameListeners(gridPad);
                swingTimer = new Timer(runTime, e -> {
                    if (gridPad.movingCheck()[1]) {
                        ter.step();
                    } else {
                        ter.lock();
                        swingTimer.stop();
                    }

                });
                swingTimer.start();
            }

        }

    }

}

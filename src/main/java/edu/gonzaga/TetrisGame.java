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
            Integer wBlock = rand.nextInt(3);
            Integer spawnX = rand.nextInt(18);
            Integer colorR = rand.nextInt(256);
            Integer colorG = rand.nextInt(256);
            Integer colorB = rand.nextInt(256);
            if (!swingTimer.isRunning()) {
                Block ter;
                switch (wBlock) {
                    case 0:
                        ter = new BlockO(gridPad.getGridBlocks(), new Point(spawnX, 0));
                        break;
                    case 1:
                        ter = new BlockL(gridPad.getGridBlocks(), new Point(spawnX, 0));
                        break;
                    case 2:
                        ter = new BlockI(gridPad.getGridBlocks(), new Point(spawnX, 0));
                        break;
                    default:
                        ter = new BlockO(gridPad.getGridBlocks(), new Point(spawnX, 0));
                        break;
                }
                ter.setColor(new Color(colorR,colorG,colorB));
                Long timer = System.currentTimeMillis();
                gridPad.addABlock(ter);
                ter.addToGameListeners(gridPad);
                swingTimer = new Timer(runTime, e -> {
                    if (gridPad.movingCheck()[1]) {
                        ter.step();
                    } else {
                        ter.lock();
                        System.out.println("stop");
                        swingTimer.stop();
                    }

                });
                swingTimer.start();
            }

        }

    }

}

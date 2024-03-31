package edu.gonzaga;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class TetrisGame {
    private Timer swingTimer;
    private Controller controller;
    JFrame application = new JFrame(); // creates a new JFrame
    public TetrisGame() {

    }

    public void startGame() throws IOException, InterruptedException {
        //set a timer
        Integer runTime = 100;
        //Create a gridPad
        GridPad gridPad = new GridPad(10, 40);
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        //GridBlockLayer is a JPanel
        GridBlockLayer grid = new GridBlockLayer(gridPad);
        grid.setSize(100, 400);
        //GUI listener can update the GUI interface.
        gridPad.addGUIListener(grid);


        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setLayout(new BorderLayout());
        application.add(grid);

        //One can try replacing these numbers with variables.
        application.setSize(100, 440);
        application.setVisible(true);
        controller = new KeyboardController(application, gridPad);
        controller.listenForKeyPressed();

        /*
        trying to center the grid, not currently working
        int x = (application.getWidth() - grid.getWidth()) / 2;
        int y = (application.getHeight() - grid.getHeight()) / 2;
        grid.setLocation(x, y);
        */

        //Setting up a Timer
        swingTimer = new Timer(500, ev -> {
        });
        while (true) {
            Integer wBlock = rand.nextInt(7);
            Integer spawnX = 4;
            Integer spawnY=1;
            //If the Timer doesn't end, i.e. the squares don't collide, then don't execute the following statement.
            if (!swingTimer.isRunning()) {
                System.out.printf("What Block: %d\n",wBlock);
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
                controller.changeTarget(ter);
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

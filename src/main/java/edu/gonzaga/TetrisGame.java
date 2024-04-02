package edu.gonzaga;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class TetrisGame {
    JFrame application = new JFrame(); // creates a new JFrame
    private Timer swingTimer;
    private Timer breakEffectTimer;
    private Controller controller;
    private ArrayList<Integer> lineDeleteBuffer;

    public TetrisGame() {
        lineDeleteBuffer = new ArrayList<Integer>();
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
        grid.setSize(150, 600);
        //GUI listener can update the GUI interface.
        gridPad.addGUIListener(grid);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setLayout(new BorderLayout());

        //One can try replacing these numbers with variables.
        application.setSize(165, 640);
        application.setVisible(true);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setLayout(new BorderLayout());
        JLayeredPane layerPanel=new JLayeredPane();
        layerPanel.setPreferredSize(application.getPreferredSize());
        layerPanel.add(grid, JLayeredPane.DEFAULT_LAYER);
        AnimeLayer anime = new AnimeLayer(grid);
        //layerPanel.add(anime,JLayeredPane.PALETTE_LAYER); //add the amine layer to the layerPanel
        application.add(layerPanel);
        controller = new KeyboardController(application, gridPad);
        controller.listenForKeyPressed();


        //trying to center the grid, not currently working
        int x = (application.getWidth() - grid.getWidth()) / 2;
        int y = (application.getHeight() - grid.getHeight()) / 2;
        layerPanel.setLocation(x, y);
        //anime.run(); /////the amine test demo

        //Setting up a Timer
        swingTimer = new Timer(500, ev -> {
        });
        Integer spawnX = 4;
        Integer spawnY=1;
        breakEffectTimer= new javax.swing.Timer(800, ev -> {
               if(!lineDeleteBuffer.isEmpty()) {
                   for (Integer aline : lineDeleteBuffer) {
                    gridPad.clearLine(aline);

                }
                gridPad.updateGame();
                lineDeleteBuffer.clear();
            }
        });
        breakEffectTimer.start();
        while (true) {
            Integer wBlock = rand.nextInt(7);
            //If the Timer doesn't end, i.e. the squares don't collide, then don't execute the following statement.
            if (!swingTimer.isRunning()) {
                System.out.printf("What Block: %d\n", wBlock);
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
                        for (int aLine = 0; aLine < gridPad.getHeight(); aLine++) {

                            if (gridPad.lineCheckMZ(aLine)) {
                                if (lineBufferCheck(aLine)) {
                                    lineDeleteBuffer.add(aLine);
                                }
                                for (int w = 0; w < gridPad.getWidth(); w++) {
                                    gridPad.getBlock(w, aLine).setDeleted(true);
                                }
                            }
                            gridPad.updateGame();

                        }
                    }
                });

                swingTimer.start();

            }

        }

    }

    private boolean lineBufferCheck(int line) {
        for (Integer aLine : lineDeleteBuffer) {
            if (line == aLine) {
                return false;
            }
        }
        return true;
    }

}

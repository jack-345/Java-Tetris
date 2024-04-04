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
    private GridPad gridPad;
    private JLabel nextBlockLabel;
    private JLabel scoreLabel;

    public TetrisGame() {
        lineDeleteBuffer = new ArrayList<Integer>();
    }

    public void startGame() throws IOException, InterruptedException {
        //set a timer
        Integer runTime = 100;
        //Create a gridPad
        this.gridPad = new GridPad(10, 40);
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        //GridBlockLayer is a JPanel
        GridBlockLayer grid = new GridBlockLayer(gridPad);
        grid.setSize(150, 600);
        //GUI listener can update the GUI interface.
        gridPad.addGUIListener(grid);
        //One can try replacing these numbers with variables.
        application.setSize(500, 700);
        application.setVisible(true);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setLayout(null);

        // Information panel for next block
        JPanel nextBlockPanel = new JPanel();
        nextBlockPanel.setBounds(350, 50, 100, 100);
        nextBlockPanel.setBorder(BorderFactory.createTitledBorder("Next Block"));
        application.add(nextBlockPanel);

        nextBlockLabel = new JLabel();
        nextBlockPanel.add(nextBlockLabel);

        // Information panel for score
        JPanel scorePanel = new JPanel();
        scorePanel.setBounds(350, 200, 100, 100);
        scorePanel.setBorder(BorderFactory.createTitledBorder("Score"));
        application.add(scorePanel);

        scoreLabel = new JLabel("0");
        scorePanel.add(scoreLabel);


        JLayeredPane layerPanel=new JLayeredPane();
        int x = (application.getWidth() - grid.getWidth()) / 2;
        int y = 32;//(application.getHeight() - grid.getHeight()) / 2;
        layerPanel.setLocation(x, y);

        BackGroundLayer moreBackGroundlayer = new BackGroundLayer(application.getWidth(),application.getHeight());
        BackGroundLayer backGroundLayer= new BackGroundLayer(180,650);
        backGroundLayer.setLocation(x-15,y-25);
        moreBackGroundlayer.add(backGroundLayer,JLayeredPane.DEFAULT_LAYER);
        layerPanel.setSize(grid.getSize());
        layerPanel.add(grid, JLayeredPane.PALETTE_LAYER);
        GhostBlockLayer anime = new GhostBlockLayer(grid, gridPad);
        layerPanel.add(anime,JLayeredPane.MODAL_LAYER); //add the amine layer to the layerPanel
        application.add(moreBackGroundlayer);
        moreBackGroundlayer.show(1);
        backGroundLayer.show(0);
        application.add(layerPanel);

        controller = new KeyboardController(application, gridPad);
        controller.listenForKeyPressed();
        //trying to center the grid, not currently working

        //Setting up a Timer
        swingTimer = new Timer(500, ev -> {
        });
        int spawnX = 4;
        int spawnY=1;

        breakEffectTimer= new javax.swing.Timer(800, ev -> {
               if(!lineDeleteBuffer.isEmpty()) {
                   for (Integer aline : lineDeleteBuffer) {
                    gridPad.clearLine(aline);

                }
                gridPad.updateGame();
                   System.out.printf("Add score: %d\n",countScore(lineDeleteBuffer.size()));
                lineDeleteBuffer.clear();
            }
        });
        breakEffectTimer.start();

        int temp = rand.nextInt(7);
        while (true) {
            Integer dBlock = rand.nextInt(7);
            Integer wBlock = 0;
            //If the Timer doesn't end, i.e. the squares don't collide, then don't execute the following statement.
            if (!swingTimer.isRunning()) {

                wBlock = temp;
                temp = dBlock;
                System.out.printf("What Block: %d\n", wBlock);
                System.out.printf("What Block Next: %d\n", dBlock);

                Block ter=getBlock(wBlock,spawnX,spawnY);

                // Display next block
                nextBlockLabel.setText(dBlock.toString());

                controller.changeTarget(ter);
                gridPad.addABlock(ter);
                ter.addToGameListeners(gridPad);
                anime.setBlock(ter);
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
    private Block getBlock(int blockID,int spawnX,int spawnY){
        Block ter;
        switch (blockID) {
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
        return ter;
    }
    private boolean lineBufferCheck(int line) {
        for (Integer aLine : lineDeleteBuffer) {
            if (line == aLine) {
                return false;
            }
        }
        return true;
    }
    public int countScore(int lines){
        int base=0;
        switch (lines) {
            case 1:
                base = 100 * lines;
                break;
            case 2:
                base = 300 * lines;
                break;
            case 3:
                base = 500 * lines;
                break;
            case 4:
                base = 800 * lines;
                break;
            default:
                System.out.println("Invalid number of lines cleared.");
        }
        return base;
    }

}

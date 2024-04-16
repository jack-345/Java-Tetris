package edu.gonzaga;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class TetrisGame {
    JFrame application = new JFrame(); // creates a new JFrame, houses all displays currently
    private Timer gameTimer; // creates a new timer to run the main grid, controls timing between block movement actions
    private Timer breakEffectTimer; // creates a new timer to determine how often to check if a line is broken and to perform the lineBroken actions
    // creates a controller, later initialized as a keyboardController, able to check for key input and change the location of the "active" block
    private Controller controller;
    // an arraylist to hold Y values in our grid to be cleared, is filled by checking how many lines are all "locked" left to right
    private ArrayList<Integer> lineDeleteBuffer; // Holds the coordinates of the lines to be deleted, can be used for scoring
    private GridPad gridPad; // Initializes a new gridPad, a 2d array of gridBlocks which have different states that can be set
    JPanel scorePanel = new JPanel(); // Information panel for score
    private JLabel scoreLabel; // An information panel that shows the current score
    NextBlockPanel nextBlockPanel = new NextBlockPanel(); // An information panel that shows the next appearing block
    JLayeredPane layerPanel = new JLayeredPane(); //New layer to place the ghost block into
    private Integer score = 0; // A variable to hold the current score, added to scoreLabel
    private boolean ifPause=false; // A variable to determine if the game is in a paused state or not
    private boolean ifGameEnd=false;

    // A constructor method that initializes lineDeleteBuffer
    public TetrisGame() {
        lineDeleteBuffer = new ArrayList<Integer>();
    }

    //The main method of a game, runs all methods
    public void startGame() throws IOException, InterruptedException {
        //set a timer, changes the amount of time between updates to the block's position, in milliseconds
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
        GhostBlockLayer anime = new GhostBlockLayer(grid, gridPad);
        layerPanel.add(anime,JLayeredPane.MODAL_LAYER); //add the amine layer to the layerPanel

        scoreLabel = new JLabel(score.toString());

        adjustApplication();
        adjustScorePanel();

        // Height calculations for placing new objects onto an application screen
        int x = (application.getWidth() - grid.getWidth()) / 2;
        int y = 32;
        adjustLayerPanel(x, y, grid);

        // Information panel for next block
        nextBlockPanel.setBounds(350, 50, 100, 100);
        nextBlockPanel.setBorder(BorderFactory.createTitledBorder("Next Block"));

        BackGroundLayer moreBackGroundlayer = new BackGroundLayer(application.getWidth(),application.getHeight());
        BackGroundLayer backGroundLayer= new BackGroundLayer(180,650);
        backGroundLayer.setLocation(x-15,y-25);
        moreBackGroundlayer.add(backGroundLayer,JLayeredPane.DEFAULT_LAYER);

        application.add(moreBackGroundlayer);
        moreBackGroundlayer.show(1);
        backGroundLayer.show(0);
        controller = new KeyboardController(application,this, gridPad);
        controller.listenForKeyPressed();

        //Setting up a Timer
        gameTimer = new Timer(500, ev -> {
        });
        int spawnX = 4;
        int spawnY=0;

        breakEffectTimer= new javax.swing.Timer(800, ev -> {
               if(!lineDeleteBuffer.isEmpty()) {
                   for (Integer aline : lineDeleteBuffer) {
                    gridPad.clearLine(aline);

                }
                gridPad.updateGame(new GridEvent(GridEvent.DELETED));
                   System.out.printf("Add score: %d\n",countScore(lineDeleteBuffer.size()));
                   score += countScore(lineDeleteBuffer.size());
                lineDeleteBuffer.clear();
            }
        });
        breakEffectTimer.start();

        // Call in a a different method later!
        // Make window visible, then start timer that will call the code below every 1ms
        int temp = rand.nextInt(7);
        while (!ifGameEnd) {
            Integer dBlock = rand.nextInt(7);
            Integer wBlock = 0;
            //If the Timer doesn't end, i.e. the squares don't collide, then don't execute the following statement.
            if (!gameTimer.isRunning()&&!ifPause) {

                wBlock = temp;
                temp = dBlock;
                System.out.printf("What Block: %d\n", wBlock);
                System.out.printf("What Block Next: %d\n", dBlock);

                Block ter=getBlock(wBlock,spawnX,spawnY);

                controller.changeTarget(ter);
                gridPad.addABlock(ter);
                ter.addToGameListeners(gridPad);
                anime.setBlock(ter);
                if(!gridPad.movingCheck()[1]){
                    endGame();
                }
                gameTimer = new Timer(runTime, e -> {

                    if (gridPad.movingCheck()[1]) {
                        // Display score
                        scoreLabel.setText("Score: " + score.toString());
                        ter.step();
                    } else {
                        ter.lock();
                        gameTimer.stop();
                        for (int aLine = 0; aLine < gridPad.getHeight(); aLine++) {

                            if (gridPad.lineCheckMZ(aLine)) {
                                if (lineBufferCheck(aLine)) {
                                    lineDeleteBuffer.add(aLine);
                                }
                                for (int w = 0; w < gridPad.getWidth(); w++) {
                                    gridPad.getBlock(w, aLine).setDeleted(true);
                                }
                            }
                            gridPad.updateGame(new GridEvent(GridEvent.ON_DELETE));

                        }
                    }
                });

                gameTimer.start();
                nextBlockPanel.updateNextBlock(getBlock(dBlock,2,2));
            }
            Thread.sleep(1);

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

    public void setPause(boolean pause){
        if(pause) {
            gameTimer.stop();
        }
        else {
            gameTimer.start();
        }
        ifPause=pause;
    }

    //a method to adjust and populate the application panel
    public void adjustApplication () {
        application.setSize(500, 700);
        application.setVisible(true);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setLayout(null);

        application.add(scorePanel);
        application.add(nextBlockPanel,null);
        application.add(layerPanel);
    }

    public void adjustScorePanel () {
        scorePanel.setBounds(350, 200, 100, 100);
        scorePanel.setBorder(BorderFactory.createTitledBorder("Score"));
        scorePanel.add(scoreLabel);
    }
    public void endGame(){
        ifGameEnd=true;
    }

    public void adjustLayerPanel (int x, int y, GridBlockLayer grid) {
        layerPanel.setLocation(x, y);
        layerPanel.setSize(grid.getSize());
        layerPanel.add(grid, JLayeredPane.PALETTE_LAYER);
    }

}

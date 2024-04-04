package edu.gonzaga;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import edu.gonzaga.TetrisGame;
import edu.gonzaga.Tetris;

public class TetrisMenu extends TetrisGame {

    private Timer swingTimer;
    private Timer breakEffectTimer;
    private Controller controller;
    private ArrayList<Integer> lineDeleteBuffer;
    private GridPad gridPad;
    private JLabel nextBlockLabel;
    private JLabel scoreLabel;
    private Integer score = 0;

    public static void main(String[] args) throws IOException, InterruptedException {

        //attempting to launch game in background, pause the timer, and make it invisible until "Play" clicked
        TetrisGame game = new TetrisGame();
        JFrame application = new JFrame();
        game.startGame();
        application.setVisible(false);
        
        //Main menu buttons to start the game, allow user to alter settings, click "How To Play" to learn controls + rules of Tetris
        JFrame mainMenuFrame = new JFrame();
        JPanel panel = new JPanel();
        JButton playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == playButton) {
                    mainMenuFrame.setVisible(false);

                    application.setVisible(true);
                    try {
                        
                        game.startGame();
                    } catch (IOException | InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                }
            }
        });

        JButton settingsButton = new JButton("Settings");
        //TODO: implement settings menu

        JButton tutorialButton = new JButton("How To Play");
        tutorialButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        panel.add(playButton);
        panel.add(settingsButton);
        panel.add(tutorialButton);
        panel.setLayout(new GridLayout(3,1));

        mainMenuFrame.add(panel);
        mainMenuFrame.setVisible(true);

    }
}

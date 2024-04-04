package edu.gonzaga;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import edu.gonzaga.TetrisGame;
import edu.gonzaga.Tetris;

public class TetrisMenu {
    public static void main(String[] args) throws IOException, InterruptedException {

        TetrisGame game = new TetrisGame();

        JFrame mainMenuFrame = new JFrame("Main Menu");
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuFrame.setSize(770, 820);
        JPanel panel = new JPanel();
        
        JButton playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == playButton) {
                    mainMenuFrame.setVisible(false);
                    JFrame application = new JFrame();
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

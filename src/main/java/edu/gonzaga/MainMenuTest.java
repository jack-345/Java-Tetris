package edu.gonzaga;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import edu.gonzaga.TetrisGame;
import edu.gonzaga.Tetris;

public class MainMenuTest {
    
    public static void main(String args[]) throws IOException, InterruptedException {
        JFrame mainMenuFrame = new JFrame("Main Menu");
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuFrame.setSize(770, 820);

        JPanel panel = new JPanel();
        
        JButton playButton = new JButton("Play");
        playButton.setBounds(50, 100, 150, 30);
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TetrisGame game = new TetrisGame();
                try {
                    game.startGame();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
            
        });


        JButton settingsButton = new JButton("Settings");
        JButton tutorialButton = new JButton("How To Play");

        panel.add(playButton);
        panel.add(settingsButton);
        panel.add(tutorialButton);
        panel.setLayout(new GridLayout(3, 1));

        mainMenuFrame.getContentPane().add(panel);
        mainMenuFrame.setVisible(true);
    }
}

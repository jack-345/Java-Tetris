package edu.gonzaga;

import javax.swing.*;
import java.awt.*;

public class MainMenuTest {
    
    public static void main(String args[]) {
        JFrame mainMenuFrame = new JFrame("Main Menu");
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuFrame.setSize(770, 820);

        JPanel panel = new JPanel();
        
        JButton playButton = new JButton("Play");
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

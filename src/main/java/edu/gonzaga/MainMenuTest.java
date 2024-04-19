package edu.gonzaga;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.gonzaga.TetrisGame;
import edu.gonzaga.Tetris;

public class MainMenuTest{
    TetrisGame game = new TetrisGame();
    StartMenu menu = new StartMenu();
    public static void main(String[] args) throws IOException, InterruptedException {
        MainMenuTest menu = new MainMenuTest();
        menu.startGame();
    }

    public MainMenuTest() throws IOException, InterruptedException{
        //create but dont show the main menu frame
        JFrame mainMenuFrame = new JFrame("Main Menu");
        createStartMenu();
        mainMenuFrame.setVisible(true);


        //WILL OPEN BOTH WINDOWS AND GAME WILL RUN ON OTHER WINDOW BUT CRASHES WHEN PLAY ON MENU CLICKED
        //create but dont show the main game window frame
        JFrame application = new JFrame();
        
        //game.startGame();
    }

    public void startGame() throws IOException, InterruptedException {
        //game.startGame(); if play clicked

        JFrame mainMenuFrame = new JFrame("Main Menu");
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuFrame.setSize(770, 820);

        JPanel panel = new JPanel();
        
        JButton playButton = new JButton("Play");
        playButton.setBounds(50, 100, 150, 30);
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == playButton) {
                    mainMenuFrame.setVisible(false);
                    
                    try {

                        //start a timer to handoff to full game
                        game.startGame();
                        //application.setVisible(true);
                    } catch (IOException | InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    System.out.println("button hit!");
                }
                
            }
            
        });


        JButton settingsButton = new JButton("Settings");
        //TODO: implement settings menu
        settingsButton.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                if (e.getSource() == settingsButton) {
                    mainMenuFrame.setVisible(false);
                    //TODO: make a new frame and panel for settings
                }
            }
        });

        JButton tutorialButton = new JButton("How To Play");
        tutorialButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == tutorialButton) {
                    mainMenuFrame.setVisible(false);
                    JPanel tutorial = new JPanel();
                }

            }
        });

        /* 
        panel.add(playButton);
        panel.add(settingsButton);
        panel.add(tutorialButton);
        */

        panel.setLayout(new GridLayout(3, 1));

        mainMenuFrame.add(panel);
        mainMenuFrame.setVisible(false);
    }

    void createStartMenu() {
        JFrame mainMenuFrame = new JFrame("Main Menu");
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuFrame.setSize(500, 700);

        JPanel panel = new JPanel();
        
        JButton playButton = new JButton("Play");
        playButton.setBounds(50, 100, 150, 30);
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == playButton) {
                    mainMenuFrame.setVisible(false);
                    //TetrisGame game = new TetrisGame();
                    try {

                        //start a timer to handoff to full game
                        game.startGame();
                        //application.setVisible(true);
                    } catch (IOException | InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    System.out.println("button hit!");
                }
                
            }
            
        });


        JButton settingsButton = new JButton("Settings");
        //TODO: implement settings menu

        JButton tutorialButton = new JButton("How To Play");
        tutorialButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == tutorialButton) {
                    mainMenuFrame.setVisible(false);
                    JPanel tutorial = new JPanel();
                }

            }
        });

        /* 
        panel.add(playButton);
        panel.add(settingsButton);
        panel.add(tutorialButton);
        panel.setLayout(new GridLayout(3, 1));
        */

        //attempting to add StartMenu JPanel to menu
        //works and button is clickable but no functionality to start the game just yet
        mainMenuFrame.add(menu);
        mainMenuFrame.setVisible(true);
    }
}


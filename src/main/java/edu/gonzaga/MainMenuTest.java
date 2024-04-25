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
    StartMenu menu = new StartMenu();
    public static void main(String[] args) throws IOException, InterruptedException {
        MainMenuTest menu = new MainMenuTest();
    }

    public MainMenuTest() throws IOException, InterruptedException{
        JFrame mainMenuFrame = new JFrame("Main Menu");
        createStartMenu();
        mainMenuFrame.setVisible(true);
    }

    void createStartMenu() {
        JFrame mainMenuFrame = new JFrame("Main Menu");
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuFrame.setSize(500, 700);
        mainMenuFrame.add(menu);
        mainMenuFrame.setVisible(true);
    }
}


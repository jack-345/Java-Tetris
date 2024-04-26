package edu.gonzaga;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StartMenu extends JPanel {
    protected BufferedImage tetrisLogo;
    protected BufferedImage backgroundImage;
    protected Image startIcon;
    public JButton startButton;
    TetrisGame game = new TetrisGame();
    public StartMenu(TetrisGame game) {
        this.game = game;
        try {
            tetrisLogo = ImageIO.read(new File("src/main/java/edu/gonzaga/SourceImg/TetrisLogo.png"));
            backgroundImage = ImageIO.read(new File("src/main/java/edu/gonzaga/SourceImg/backgroundImg.png"));
            startIcon = ImageIO.read(new File("src/main/java/edu/gonzaga/SourceImg/StartButton.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(null);
        setSize(500, 700);
        setVisible(true);
        startButton = new JButton();
        startButton.setSize(100,50);
        startButton.setLocation(200,400);
        startButton.setVisible(true);
        startButton.setText("Start Game");
        //startButton.setIcon(new ImageIcon(startIcon));

        startButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
            if (e.getSource() == startButton) {
                try {
                    game.startGame();
                    setVisible(false);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
           } 
        });
        add(startButton);
    }
    public StartMenu(){

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0,500,700, null);
        g.drawImage(tetrisLogo, 50, 0,400,300, null);
    }
}
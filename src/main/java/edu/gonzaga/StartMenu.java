package edu.gonzaga;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.IconUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StartMenu extends JPanel {
    protected BufferedImage tetrisLogo;
    protected BufferedImage backgroundImage;
    protected ImageIcon startIcon;
    protected JButton startButton;
    protected JLabel nameLabel;
    protected String info="Tetris Game by [Team Tetris: Jack Ou, Nick DeYoung, Mingze Zhang]";
    TetrisGame game;
    public StartMenu(TetrisGame game) {
        this.game = game;
        try {
            tetrisLogo = ImageIO.read(new File("src/main/java/edu/gonzaga/SourceImg/TetrisLogo.png"));
            backgroundImage = ImageIO.read(new File("src/main/java/edu/gonzaga/SourceImg/backgroundImg.png"));
            startIcon = new ImageIcon(ImageIO.read(new File("src/main/java/edu/gonzaga/SourceImg/StartButton.png")));
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
       // startButton.setIcon(startIcon);
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
        nameLabel=new JLabel();
        nameLabel.setLocation(30,650);
        nameLabel.setSize(600,20);
        //nameLabel.setText();
        //nameLabel.setVisible(true);
      //  add(nameLabel);
    }
    public StartMenu(){
        this(new TetrisGame());
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0,500,700, null);
        g.drawImage(tetrisLogo, 50, 0,400,300, null);
        g.setColor(new Color(255,255,255));
        g.drawBytes(info.getBytes(),0,info.getBytes().length, 30,650);
    }
}
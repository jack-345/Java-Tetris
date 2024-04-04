package edu.gonzaga;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackGroundLayer extends JLayeredPane {
    BufferedImage backgroundImage;
    BufferedImage backgroundImage2;
    public BackGroundLayer(int width,int height){
        super();
        setSize(width,height);
        setVisible(true);

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage,0,0,getWidth(),getHeight(),null);
    }
    public void show(int img){
        try {
        if(img==0){
            backgroundImage= ImageIO.read(new File("src/main/java/edu/gonzaga/SourceImg/backGroundLayer2.png"));

        }
        else {
            backgroundImage=ImageIO.read(new File("src/main/java/edu/gonzaga/SourceImg/backgroundImg.png"));
        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        repaint();
    }
}

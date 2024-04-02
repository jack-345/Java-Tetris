package edu.gonzaga;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AnimeLayer extends JLayeredPane {
    public AnimeLayer(GridBlockLayer blockLayer){
        super();
        setSize(blockLayer.getSize());
        setVisible(true);
        //setBackground(Color.WHITE);    
        //setOpaque(false);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth(); // total width
        int height = getHeight(); // total height
        //g.setColor(Color.WHITE);
        //g.fillRect(0,0,30,90);
    }
    public void update(Integer amine){

    }
}

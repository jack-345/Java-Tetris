package edu.gonzaga;

import javax.swing.*;
import java.awt.*;

public class AnimeLayer extends JLayeredPane {
    int x = 0;
    int y = 0;
    int velX = 5;
    private Timer timer;

    public AnimeLayer(GridBlockLayer blockLayer) {
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
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 50, 50);
        //System.out.println("Draw");
    }

    public void run() {
        timer = new Timer(10, e -> {
            if (x < 0 || x > getWidth() - 50) {
                velX = -velX;
            }
            x += velX;
           // System.out.println(x);
            repaint();
        });
        timer.start();
    }

    public void update() {
    }
}

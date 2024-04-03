package edu.gonzaga;

import javax.swing.*;
import java.awt.*;

public class AnimeLayer extends JLayeredPane {
    Point p;
    Block ghostTer;
    private Timer timer;

    public AnimeLayer(GridBlockLayer blockLayer) {
        super();
        setSize(blockLayer.getSize());
        setVisible(true);
        //setBackground(Color.WHITE);
        //setOpaque(false);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void setBlock(Block ter) {
        this.ghostTer = ter;
        this.p = ter.getCenter();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth(); // total width
        int height = getHeight(); // total height

        Color backgroundColor = new Color(255, 255, 255, 45);
        g.setColor(backgroundColor);
        for(Point p : this.ghostTer.getShape()) {
            g.fillRect(p.x * 15, height - 15 , 15, 15);
        }
        //System.out.println("Draw");
    }

    public void run() {
        timer = new Timer(10, e -> {
            repaint();
        });
        timer.start();
    }

    public void update() {
    }
}

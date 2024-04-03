package edu.gonzaga;

import javax.swing.*;
import java.awt.*;

public class AnimeLayer extends JLayeredPane {
    Point p;
    Block ghostTer;
    private Timer timer;
    GridPad gridPad;

    public AnimeLayer(GridBlockLayer blockLayer, GridPad gridPad) {
        super();
        setSize(blockLayer.getSize());
        setVisible(true);
        this.gridPad = gridPad;
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
        //int width = getWidth(); // total width
        int height;
        int gridSize = 15;
        Color backgroundColor = new Color(255, 255, 255, 45);
        g.setColor(backgroundColor);

        for(Point p : ghostTer.shape) {
            height = gridPad.findLockHeight(p.x); // total height
            int y = height - gridSize;// Adding 1 to p.y to ensure the bottom-most row is at the bottom
            g.fillRect(p.x * gridSize, y, gridSize, gridSize);
        }
        //System.out.println("Draw");
    }

    public void update() {
    }
}

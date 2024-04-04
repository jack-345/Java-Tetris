package edu.gonzaga;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GhostBlockLayer extends JLayeredPane {
    Point p;
    Block ghostTer;
    private Timer timer;
    GridPad gridPad;
    ArrayList<Point> ghostShape;
    public GhostBlockLayer(GridBlockLayer blockLayer, GridPad gridPad) {
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
        //ghostShape= new ArrayList<Point>();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //int width = getWidth(); // total width
        int highest=getHeight();
        int height = 0;
        int lowestBlockPoint=0;
        int gridSize = 15;
        int closest=getHeight();
        Point blockWillTouchClone = null;
        Point blockWillTouch = p;
        Color backgroundColor = new Color(255, 255, 255, 45);
        g.setColor(backgroundColor);
        ghostShape= new ArrayList<Point>();
        for(Point p : ghostTer.getShape()){
            ghostShape.add((Point) p.clone());
        }

        for (int i=0;i<ghostShape.size();i++){
            ghostShape.get(i).setLocation(ghostTer.getShape().get(i).getX(),ghostShape.get(i).getY());
        }

        for (Point p:ghostShape){
            height = gridPad.findLockHeight(p); // total height
            if(height-p.y*gridSize<closest){
                closest=height-p.y*gridSize;
                blockWillTouchClone= (Point) p.clone();
                blockWillTouch=p;
                //System.out.print(height-p.y*gridSize);

            }
            if(p.y>lowestBlockPoint){
                lowestBlockPoint=p.y;
            }
        }
        for(Point p : ghostShape){
            p.y=(getHeight()/gridSize-lowestBlockPoint)+p.y;
            //System.out.println(p.y);
        }
        highest=gridPad.findLockHeight(blockWillTouchClone);
        //System.out.println(highest);
        for(Point p : ghostShape) {
            int y = highest - gridSize;// Adding 1 to p.y to ensure the bottom-most row is at the bottom
            g.fillRect(p.x * gridSize, (p.y-1)*gridSize-(blockWillTouch.y-highest/gridSize)*gridSize, gridSize, gridSize);
           // System.out.println(p.y);
            //System.out.println(blockWillTouch.y-highest/gridSize);
            //System.out.println(blockWillTouch);
            //System.out.println(highest);
        }
        //System.out.println("Draw");
    }

    public void update() {
    }
}

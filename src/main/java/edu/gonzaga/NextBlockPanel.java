package edu.gonzaga;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class NextBlockPanel extends JPanel {
   // GridPad nextBlockGridPad;
    ArrayList<Point> shape;
    Block block;
    protected BufferedImage blockImage;
    protected BufferedImage backGroundImage;
    protected BufferedImage breakImage;
    public NextBlockPanel(){
        try {
            blockImage = ImageIO.read(new File("src/main/java/edu/gonzaga/SourceImg/gridBlock.png"));
            //backGroundImage = ImageIO.read(new File("src/main/java/edu/gonzaga/SourceImg/backGround.png"));
            //breakImage = ImageIO.read(new File("src/main/java/edu/gonzaga/SourceImg/breakImage.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //nextBlockGridPad=new GridPad(40,40);
        shape = new ArrayList<Point>();
        //setBounds(350, 50, 100, 100);
        //setBorder(BorderFactory.createTitledBorder("Next Block"));
        setVisible(true);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.setColor(new Color(255,255,255));
        g.fillRect(0,0,getWidth(),getHeight());
        for(Point p : shape){
            g.drawImage(tintImage(blockImage, block.getColor(), 0.3F), p.x * 15, p.y * 15, 15, 15, null);
        }

    }
    private BufferedImage tintImage(BufferedImage src, Color color, float alpha) {
        alpha = Math.min(Math.max(alpha, 0.0f), 1.0f);
        BufferedImage result = new BufferedImage(src.getWidth(), src.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = result.createGraphics();
        g2d.drawImage(src, 0, 0, null);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2d.setColor(color);
        g2d.fillRect(0, 0, src.getWidth(), src.getHeight());
        g2d.dispose();
        return result;
    }
    public void updateNextBlock(Block block){
        System.out.println("Run nextBlock");
        this.block=block;
        shape.clear();
        for(Point p : block.getShape()){
            shape.add(((Point) p.clone()));
        }
        repaint();
    }
}

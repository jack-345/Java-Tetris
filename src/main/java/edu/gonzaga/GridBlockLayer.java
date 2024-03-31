package edu.gonzaga;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GridBlockLayer extends JPanel implements GUIListener{
    private GridPad gridPad;
    private BufferedImage blockImage;
    private BufferedImage backGroundImage;
    public GridBlockLayer(GridPad gridPad){
        super();
        this.gridPad=gridPad;
        setVisible(true);
        try {
            blockImage = ImageIO.read(new File("src/main/java/edu/gonzaga/SourceImg/gridBlock.png"));
            backGroundImage=ImageIO.read(new File("src/main/java/edu/gonzaga/SourceImg/backGround.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(gridPad.getWidth()*15,gridPad.getHeight()*15);
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int width = getWidth(); // total width
        int height = getHeight(); // total height
        for (int i = 0; i < gridPad.getHeight(); i++)
        {
            for(int j=0;j<gridPad.getWidth();j++){
                if(gridPad.getBlock(j,i).isFill()){
                    Color color = gridPad.getBlock(j, i).getColor();
                    BufferedImage coloredImage = tintImage(blockImage, color, 0.3F);
                    g.drawImage(coloredImage, j * 15, i * 15, 15, 15, null);
                }
                else {
                    g.drawImage(tintImage(blockImage,new Color(0,0,0),0.7F), j * 15, i * 15, 15, 15, null);
                }
            }
        }
    }
    private BufferedImage tintImage(BufferedImage src, Color color,float alpha) {
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

    @Override
    public void update() {
        repaint();
    }
}

package edu.gonzaga;

import javax.swing.*;
import java.awt.*;

public class GridBlockLayer extends JPanel implements GUIListener{
    private GridPad gridPad;

    public GridBlockLayer(GridPad gridPad){
        super();
        this.gridPad=gridPad;
        setVisible(true);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(gridPad.getWidth()*10,gridPad.getHeight()*10);
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
                    g.setColor(gridPad.getBlock(j,i).getColor());
                    g.fillRect(j*10, i*10, 10, 10);
                    g.setColor(new Color(255,255,255));
                }
                else {
                    //g.drawRect(j * 10, i * 10, 10, 10);
                }
            }
        }
    }

    @Override
    public void update() {
        repaint();
    }
}

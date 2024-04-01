package edu.gonzaga;

import java.awt.*;
import java.util.ArrayList;

public class BlockO extends Block {
    @Override
    public void rotate(int direction) {
        super.rotate(0,shape.get(1));
    }

    @Override
    public Point getCenter() {
        return shape.get(1);
    }

    @Override
    public int getType() {
        return 0;
    }

    public BlockO(GridBlock[][] gridBlocks, Point spawnPoint){
        super(gridBlocks,spawnPoint, new Color(255, 255, 0));
        shape = new ArrayList<Point>();
        shape.add(new Point(bias.x, bias.y));
        shape.add(new Point(bias.x,1+bias.y));
        shape.add(new Point(1+bias.x,bias.y));
        shape.add(new Point(1+bias.x,1+bias.y));

    }


}

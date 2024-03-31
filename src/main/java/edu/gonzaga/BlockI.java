package edu.gonzaga;

import java.awt.*;
import java.util.ArrayList;

public class BlockI extends Block {
    @Override
    public void rotate(int direction) {
        direction=Math.abs(direction)-2;
        super.rotate(direction,shape.get(2));
    }

    public BlockI(GridBlock[][] gridBlocks, Point spawnPoint){
        super(gridBlocks,spawnPoint);
        shape = new ArrayList<Point>();
        shape.add(new Point(bias.x, bias.y));
        shape.add(new Point(bias.x,1+bias.y));
        shape.add(new Point(bias.x,2+bias.y));
        shape.add(new Point(bias.x,3+bias.y));

    }


}

package edu.gonzaga;

import java.awt.*;
import java.util.ArrayList;

public class BlockL extends Block {
    @Override
    public void rotate(int direction) {
        super.rotate(direction,shape.get(1));
    }

    public BlockL(GridBlock[][] gridBlocks, Point spawnPoint){
        super(gridBlocks,spawnPoint, new Color(255, 127, 0));
        shape = new ArrayList<Point>();
        shape.add(new Point(bias.x, bias.y));
        shape.add(new Point(bias.x,1+bias.y));
        shape.add(new Point(bias.x,2+bias.y));
        shape.add(new Point(1+bias.x,2+bias.y));

    }


}

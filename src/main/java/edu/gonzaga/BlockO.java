package edu.gonzaga;

import java.awt.*;
import java.util.ArrayList;

public class BlockO extends Block {
    public BlockO(GridBlock[][] gridBlocks, Point spawnPoint){
        super(gridBlocks,spawnPoint);
        shape = new ArrayList<Point>();
        shape.add(new Point(bias.x, bias.y));
        shape.add(new Point(bias.x,1+bias.y));
        shape.add(new Point(1+bias.x,bias.y));
        shape.add(new Point(1+bias.x,1+bias.y));

    }


}
